package service.common.factory;

import service.common.IntegralOrderAmount;
import service.common.enums.ShoppingIntegralEnum;
import service.common.impl.ShoppingCostExceedOneThousand;
import service.common.impl.ShoppingCostFiveAndOneThousand;
import service.common.impl.ShoppingCostFiveHundred;

import java.util.HashMap;
import java.util.Map;


/**
 * 拆分if else 需要的工厂类
 *
 * @author 吧嘻小米
 * @date 2020/07/09
 */
public class DealClassFactory {

    private static Map<ShoppingIntegralEnum, IntegralOrderAmount> dealClassFactory = new HashMap<ShoppingIntegralEnum, IntegralOrderAmount>();


    static {
        dealClassFactory.put(ShoppingIntegralEnum.ShoppingCostFiveHundred, new ShoppingCostFiveHundred());
        dealClassFactory.put(ShoppingIntegralEnum.ShoppingCostFiveAndOneThousand, new ShoppingCostFiveAndOneThousand());
        dealClassFactory.put(ShoppingIntegralEnum.ShoppingCostExceedOneThousand, new ShoppingCostExceedOneThousand());
    }

    /**
     * 获取对应的实现类
     *
     * @param shoppingIntegralEnum shoppingIntegralEnum
     * @return
     */
    public static IntegralOrderAmount getDealClass(ShoppingIntegralEnum shoppingIntegralEnum) {
        return dealClassFactory.get(shoppingIntegralEnum);
    }
}
