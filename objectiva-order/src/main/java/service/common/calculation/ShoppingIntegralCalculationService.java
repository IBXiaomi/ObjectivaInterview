package service.common.calculation;

import com.objectiva.interview.entity.Integral;
import com.objectiva.interview.integral.common.BaseIntegralService;

import java.math.BigDecimal;

/**
 * 购物积分计算
 *
 * @author 吧嘻小米
 * @date 2020/07/09
 */
public class ShoppingIntegralCalculationService extends BaseIntegralService {

    private static ShoppingIntegralCalculationService shoppingIntegralCalculation;

    private ShoppingIntegralCalculationService() {
    }

    public static ShoppingIntegralCalculationService getShoppingIntegralCalculation() {
        if (null == shoppingIntegralCalculation) {
            synchronized (ShoppingIntegralCalculationService.class) {
                if (null == shoppingIntegralCalculation) {
                    shoppingIntegralCalculation = new ShoppingIntegralCalculationService();
                }
            }
        }
        return shoppingIntegralCalculation;
    }

    /**
     * 增加积分
     *
     * @param integral    积分
     * @param newIntegral 新增积分
     */
    public void addIntegral(Integral integral, BigDecimal newIntegral) {
        super.addIntegral(integral, newIntegral);
    }
}
