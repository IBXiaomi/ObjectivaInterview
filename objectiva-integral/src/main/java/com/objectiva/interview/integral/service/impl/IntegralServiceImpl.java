package com.objectiva.interview.integral.service.impl;

import com.objectiva.interview.entity.Integral;
import com.objectiva.interview.entity.User;
import com.objectiva.interview.integral.dao.IntegralMapper;
import com.objectiva.interview.integral.dao.UserMapper;
import com.objectiva.interview.integral.service.IntegralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 积分操作实现类
 *
 * @author 吧嘻小米
 * @date 2020/07/09
 */
@Service
public class IntegralServiceImpl implements IntegralService {


    @Autowired
    IntegralMapper integralMapper;

    @Autowired
    UserMapper userMapper;

    /**
     * 获取积分总数
     *
     * @param user 用户id
     * @return sumIntegral
     */
    public BigDecimal getSumIntegral(User user) {
        return userMapper.findSumIntegral(user);
    }

    /**
     * 获取积分的有效时间
     *
     * @param integral 用户id
     * @return validityIntegral
     */
    public Date getValidityIntegral(Integral integral) {
        return integralMapper.findIntegralValidity(integral);
    }

    /**
     * 获取积分消费记录
     *
     * @param integral 用户id
     * @return integralConsumerRecord
     */
    public List<String> getIntegralConsumerRecord(Integral integral) {
        return integralMapper.findIntegralConsumerRecord(integral);
    }
}
