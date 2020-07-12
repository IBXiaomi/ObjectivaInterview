package com.objectiva.interview.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 用户表
 *
 * @author 吧嘻小米
 * @date 2020/07/09
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -916357210051689789L;

    /**
     * 用户id
     */
    private String id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 订单id
     */
    private String OrderId;

    /**
     * 积分id
     */
    private String IntegralId;

    /**
     * 签到数
     */
    private int signNumber;

    /**
     * 评论数
     */
    private int commentNumber;

    /**
     * 总积分数
     */
    private BigDecimal sumIntegral;
}
