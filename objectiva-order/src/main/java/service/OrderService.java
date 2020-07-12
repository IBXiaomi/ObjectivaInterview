package service;

import com.objectiva.interview.entity.Integral;
import com.objectiva.interview.entity.Order;
import com.objectiva.interview.entity.User;

/**
 * 订单模块
 *
 * @author 吧嘻小米
 * @date 2020/07/09
 */
public interface OrderService {
    /**
     * 根据订单金额获取积分
     *
     * @param order    订单金额
     * @param integral 积分
     */
    void getIntegralFromShopping(Order order, Integral integral);

    /**
     * 购物积分减免
     *
     * @param user  用户
     * @param order 订单
     */
    void shoppingByIntegral(User user, Order order);

    /**
     * 设置积分过期时间
     *
     * @param integral       积分
     * @param expirationTime 过期时间
     */
    void setIntegralExpirationDate(Integral integral, int expirationTime);
}
