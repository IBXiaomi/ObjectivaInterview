package service.impl;

import com.objectiva.interview.entity.Integral;
import com.objectiva.interview.entity.Order;
import com.objectiva.interview.entity.User;
import com.objectiva.interview.integral.common.BaseIntegralService;
import com.objectiva.interview.integral.service.IntegralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.OrderService;
import service.common.JudgmentOrderAmount;
import service.common.constant.ShoppingConstant;
import service.common.enums.ShoppingIntegralEnum;
import service.common.factory.DealClassFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单模块
 *
 * @author 吧嘻小米
 * @date 2020/07/09
 */
@Service
public class OrderServiceImpl extends BaseIntegralService implements OrderService {
    private static final BigDecimal ORDER_NUMBER = new BigDecimal(10);

    private static List<JudgmentOrderAmount> list = new ArrayList<JudgmentOrderAmount>(3);

    static {
        list.add(new JudgmentOrderAmount(0, ShoppingConstant.ORDER_AMOUNT_NO_1,
                DealClassFactory.getDealClass(ShoppingIntegralEnum.ShoppingCostFiveHundred)));
        list.add(new JudgmentOrderAmount(ShoppingConstant.ORDER_AMOUNT_NO_1, ShoppingConstant.ORDER_AMOUNT_NO_2,
                DealClassFactory.getDealClass(ShoppingIntegralEnum.ShoppingCostFiveAndOneThousand)));
        list.add(new JudgmentOrderAmount(ShoppingConstant.ORDER_AMOUNT_NO_2, Integer.MAX_VALUE,
                DealClassFactory.getDealClass(ShoppingIntegralEnum.ShoppingCostExceedOneThousand)));
    }


    @Autowired
    IntegralService integralService;

    @Autowired
    OrderService orderService;

    /**
     * 根据订单金额获取积分
     *
     * @param order    订单金额
     * @param integral 积分
     */
    public void getIntegralFromShopping(Order order, Integral integral) {
        if (null != order && null != integral) {
            for (JudgmentOrderAmount judgmentOrderAmount : list) {
                if (judgmentOrderAmount.inRange(order.getOrderAmount())) {
                    judgmentOrderAmount.getIntegral(order, integral);
                }
            }
        }
    }

    /**
     * 购物积分减免
     *
     * @param user  用户
     * @param order 订单
     */
    public void shoppingByIntegral(User user, Order order) {
        BigDecimal sumIntegral = integralService.getSumIntegral(user);

        int result = sumIntegral.compareTo(new BigDecimal("0"));
        if (result > 0) {
            // 默认不进行四舍五入,直接去除掉小数点后面的值
            // 第一个参数表示除数，第二个参数表示保留几位小数，第三个参数表示使用的模式
            BigDecimal divide = sumIntegral.divide(ORDER_NUMBER, 0, BigDecimal.ROUND_DOWN);
            order.setOrderAmount(order.getOrderAmount() - divide.intValue());
            BigDecimal newIntegral = ORDER_NUMBER.multiply(divide);
            user.setSumIntegral(newIntegral);
            // 将订单金额和减免后的积分插入数据库中
        }
    }

    /**
     * 设置积分过期时间
     *
     * @param integral       积分
     * @param expirationTime 过期时间
     */
    public void setIntegralExpirationDate(Integral integral, int expirationTime) {
        super.setIntegralExpirationDate(integral, ShoppingConstant.EXPIRATION_TIME);
    }
}
