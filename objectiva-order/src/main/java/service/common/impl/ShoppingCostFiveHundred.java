package service.common.impl;

import com.objectiva.interview.entity.Integral;
import com.objectiva.interview.entity.Order;
import service.common.IntegralOrderAmount;
import service.common.calculation.ShoppingIntegralCalculationService;

import java.math.BigDecimal;


/**
 * 获取积分，订单金额在500以内
 *
 * @author 吧嘻小米
 * @date 2020/07/09
 */
public class ShoppingCostFiveHundred implements IntegralOrderAmount {


    /**
     * 获取积分
     *
     * @param order    订单金额
     * @param integral 积分id
     */
    public void getIntegralFromOrderAmount(Order order, Integral integral) {
        float integralNumber = order.getOrderAmount() * 0.1f;
        ShoppingIntegralCalculationService.getShoppingIntegralCalculation().
                addIntegral(integral, new BigDecimal(String.valueOf(integralNumber)));
    }

}
