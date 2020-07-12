package com.objectiva.interview.integral.dao;

import com.objectiva.interview.entity.Integral;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 积分dao
 *
 * @author 吧嘻小米
 * @date 2020/07/09
 */
@Repository
public interface IntegralMapper {

    /**
     * 获取积分有限时间
     *
     * @param integral 积分对象
     * @return
     */
    Date findIntegralValidity(Integral integral);

    /**
     * 增加积分
     *
     * @param integral 积分对象
     */
    void insertIntegral(Integral integral);

    /**
     * 获取积分消费记录
     *
     * @param integral 积分对象
     * @return
     */
    List<String> findIntegralConsumerRecord(Integral integral);

    /**
     * 积分创建时间
     *
     * @param integral 积分对象
     * @return
     */
    Date findIntegralCreateDate(Integral integral);

    /**
     * 设置积分过期时间
     *
     * @param integral 积分对象
     */
    void insertIntegralExpirationDate(Integral integral);

    /**
     * 根据积分对象查找积分
     *
     * @param integral 积分对象
     * @return
     */
    BigDecimal findIntegralByIntegral(Integral integral);

    /**
     * 查找积分对象
     *
     * @param integral 积分id
     * @return
     */
    Integral findIntegralByIntegralId(Integral integral);
}
