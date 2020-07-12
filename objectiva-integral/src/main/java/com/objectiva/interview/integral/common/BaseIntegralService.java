package com.objectiva.interview.integral.common;

import com.objectiva.interview.entity.Integral;
import com.objectiva.interview.entity.User;
import com.objectiva.interview.integral.dao.IntegralMapper;
import com.objectiva.interview.integral.service.IntegralService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 公共的积分方法
 *
 * @author 吧嘻小米
 * @date 2020/07/09
 */
public abstract class BaseIntegralService implements IntegralService {

    @Autowired
    IntegralMapper integralMapper;

    /**
     * 增加积分
     *
     * @param integral 积分
     */
    public void addIntegral(Integral integral, BigDecimal integralNumber) {
        BigDecimal oldIntegral = integralMapper.findIntegralByIntegralId(integral);
        BigDecimal bigDecimal = integralNumber.add(oldIntegral);
        integral.setCommentIntegral(bigDecimal);
        integralMapper.insertIntegral(integral);
    }

    /**
     * 设置积分过期时间
     *
     * @param integral       积分
     * @param expirationTime 有效期
     */
    public void setIntegralExpirationDate(Integral integral, int expirationTime) {
        Date createDate = integralMapper.findIntegralCreateDate(integral);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(createDate);
        calendar.add(Calendar.MONTH, expirationTime);
        Date expirationTimeResult = calendar.getTime();
        integral.setExpirationDate(expirationTimeResult);
        integralMapper.insertIntegralExpirationDate(integral);
    }

    /**
     * 根据useId获取积分总数
     *
     * @param user 用户id
     * @return sumIntegral
     */
    public BigDecimal getSumIntegral(User user) {
        return null;
    }

    /**
     * 查询对应积分的有效期
     *
     * @param integral 积分id
     * @return validityIntegral
     */
    public Date getValidityIntegral(Integral integral) {
        return null;
    }

    /**
     * 获取用户的积分消费记录
     *
     * @param integral 用户id
     * @return integralConsumerRecord
     */
    public List<String> getIntegralConsumerRecord(Integral integral) {
        return null;
    }
}
