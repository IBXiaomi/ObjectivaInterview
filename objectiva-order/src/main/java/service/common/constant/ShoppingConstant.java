package service.common.constant;

/**
 * 购物相关的常量
 *
 * @author 吧嘻小米
 * @date 2020/07/09
 */
public interface ShoppingConstant {
    /**
     * 过期时间为3个月
     */
    int EXPIRATION_TIME = 3 ;

    /**
     * 不存在插入
     */
    String NX = "NX";

    /**
     * 时间单位
     */
    String EX = "EX";

    /**
     * 订单金额条件1
     */
    int ORDER_AMOUNT_NO_1 = 500;

    /**
     * 订单金额条件2
     */
    int ORDER_AMOUNT_NO_2 = 1000;
}
