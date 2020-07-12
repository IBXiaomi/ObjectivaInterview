package com.objectiva.interview.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 积分表
 *
 * @author 吧嘻小米
 * @date 2020/07/09
 */
@Data
public class Integral {
    private static final long serialVersionUID = 554618486115416541L;

    /**
     * 积分id
     */
    private String integralId;

    /**
     * 购物获得积分
     */
    private BigDecimal shoppingIntegral;

    /**
     * 评论获得积分
     */
    private BigDecimal commentIntegral;

    /**
     * 签到获得积分
     */
    private BigDecimal signIntegral;

    /**
     * 积分创建时间
     */
    private Date createDate;

    /**
     * 积分过期时间
     */
    private Date expirationDate;

    /**
     * 记录
     */
    private String record;
}
