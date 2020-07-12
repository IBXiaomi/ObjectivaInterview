package service.common;

import com.objectiva.interview.entity.Integral;
import com.objectiva.interview.entity.Order;

/**
 * 拆分if else
 *
 * @author 吧嘻小米
 * @date 2020/07/09
 */
public class JudgmentOrderAmount {

    private int start;

    private int end;

    private IntegralOrderAmount integralOrderAmount;

    public JudgmentOrderAmount(int start, int end, IntegralOrderAmount integralOrderAmount) {
        this.start = start;
        this.end = end;
        this.integralOrderAmount = integralOrderAmount;
    }

    /**
     * 判断当前金额的范围
     *
     * @param orderAmount 订单金额
     * @return boolean
     */
    public boolean inRange(int orderAmount) {
        return start < orderAmount && orderAmount <= end;
    }

    /**
     * 获取积分
     *
     * @param order    订单金额
     * @param integral 积分
     */
    public void getIntegral(Order order, Integral integral) {
        integralOrderAmount.getIntegralFromOrderAmount(order, integral);
    }
}
