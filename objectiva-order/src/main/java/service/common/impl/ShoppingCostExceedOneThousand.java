package service.common.impl;

import com.objectiva.interview.entity.Integral;
import com.objectiva.interview.entity.Order;
import service.common.IntegralOrderAmount;
import service.common.calculation.ShoppingIntegralCalculationService;

import java.math.BigDecimal;


/**
 * 消费获取积分，1000以上
 *
 * @author 吧嘻小米
 * @date 2020/07/09
 */
public class ShoppingCostExceedOneThousand implements IntegralOrderAmount {

    /**
     * 获取积分并设置过期时间
     *
     * @param order    订单金额
     * @param integral 积分id
     */
    public void getIntegralFromOrderAmount(Order order, Integral integral) {
        float integralNumber = order.getOrderAmount() * 0.2f;
        ShoppingIntegralCalculationService.getShoppingIntegralCalculation().
                addIntegral(integral, new BigDecimal(String.valueOf(integralNumber)));
    }
}
