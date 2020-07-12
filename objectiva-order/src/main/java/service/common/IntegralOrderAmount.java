package service.common;

import com.objectiva.interview.entity.Integral;
import com.objectiva.interview.entity.Order;

/**
 * 判断订单金额大小
 *
 * @author 吧嘻小米
 * @date 2020/07/09
 */
public interface IntegralOrderAmount {

    /**
     * 获取积分
     *
     * @param order    订单金额
     * @param integral 积分id
     */
    void getIntegralFromOrderAmount(Order order, Integral integral);
}
