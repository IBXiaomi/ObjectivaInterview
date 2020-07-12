package com.objectiva.interview.user.service;

import com.objectiva.interview.entity.Integral;
import com.objectiva.interview.entity.User;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 用户模块
 *
 * @author 吧嘻小米
 * @date 2020/07/09
 */
public interface UserService {
    /**
     * 获取积分总数
     *
     * @param user 用户id
     * @return sumIntegral
     */
    BigDecimal getSumIntegral(User user);

    /**
     * 获取积分的有效时间
     *
     * @param integral 用户id
     * @return validityIntegral
     */
    Date getValidityIntegral(Integral integral);


    /**
     * 获取积分消费记录
     *
     * @param integral 用户id
     * @return integralConsumerRecord
     */
    List<String> getIntegralConsumerRecord(Integral integral);
}
