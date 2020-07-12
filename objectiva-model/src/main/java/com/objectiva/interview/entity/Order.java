package com.objectiva.interview.entity;

import lombok.Data;

import java.util.Date;

/**
 * 订单表
 *
 * @author 吧嘻小米
 * @date 2020/07/09
 */
@Data
public class Order {
    private static final long serialVersionUID = 8656128222714547171L;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 订单金额
     */
    private int orderAmount;


    /**
     * 订单创建日期
     */
    private Date createOrderDate;
}
