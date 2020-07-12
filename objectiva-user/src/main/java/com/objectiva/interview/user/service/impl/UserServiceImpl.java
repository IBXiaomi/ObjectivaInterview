package com.objectiva.interview.user.service.impl;

import com.objectiva.interview.entity.Integral;
import com.objectiva.interview.entity.User;
import com.objectiva.interview.integral.service.IntegralService;
import com.objectiva.interview.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 用户模块实现类
 *
 * @author 吧嘻小米
 * @date 2020/07/09
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    IntegralService integralService;

    /**
     * 获取积分总数
     *
     * @param user 用户id
     * @return sumIntegral
     */
    public BigDecimal getSumIntegral(User user) {
        return integralService.getSumIntegral(user);
    }

    /**
     * 获取积分的有效时间
     *
     * @param integral 用户id
     * @return validityIntegral
     */
    public Date getValidityIntegral(Integral integral) {
        return integralService.getValidityIntegral(integral);
    }

    /**
     * 获取积分消费记录
     *
     * @param integral 用户id
     * @return integralConsumerRecord
     */
    public List<String> getIntegralConsumerRecord(Integral integral) {
        return integralService.getIntegralConsumerRecord(integral);
    }
}
