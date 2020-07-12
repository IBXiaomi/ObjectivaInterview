package com.onjectiva.interview.sign.service.impl;

import com.objectiva.interview.entity.Integral;
import com.objectiva.interview.entity.User;
import com.objectiva.interview.integral.common.BaseIntegralService;
import com.objectiva.interview.integral.service.IntegralService;
import com.onjectiva.interview.sign.service.SignService;
import com.onjectiva.interview.sign.service.common.SignConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 签到获取积分
 *
 * @author 吧嘻小米
 * @date 2020/07/09
 */
@Service
public class SignImplService extends BaseIntegralService implements SignService {

    @Autowired
    IntegralService integralService;

    /**
     * 签到获取积分
     *
     * @param user     签到次数
     * @param integral 积分id
     */
    public void getIntegralFromSign(User user, Integral integral) {
        int signNumber = user.getSignNumber();
        int integralNumber = signNumber < SignConstant.SIGN_NUMBER_THIRTY ?
                signNumber * SignConstant.SIGN_NUMBER_TEN : signNumber * SignConstant.SIGN_NUMBER_TWENTY;
        super.addIntegral(integral, new BigDecimal(String.valueOf(integralNumber)));
    }

    /**
     * 设置签到积分过期时间
     *
     * @param integral       积分
     * @param expirationTime 有效期
     */
    public void setIntegralExpirationDate(Integral integral, int expirationTime) {
        super.setIntegralExpirationDate(integral, SignConstant.EXPIRATION_TIME);
    }
}
