package com.onjectiva.interview.sign.service;

import com.objectiva.interview.entity.Integral;
import com.objectiva.interview.entity.User;

/**
 * 签到
 *
 * @author 吧嘻小米
 * @date 2020/07/09
 */
public interface SignService {

    /**
     * 签到获取积分
     *
     * @param user     签到次数
     * @param integral 积分id
     */
    void getIntegralFromSign(User user, Integral integral);

    /**
     * 设置签到积分过期时间
     *
     * @param integral       积分
     * @param expirationTime 有效期
     */
    void setIntegralExpirationDate(Integral integral, int expirationTime);
}
