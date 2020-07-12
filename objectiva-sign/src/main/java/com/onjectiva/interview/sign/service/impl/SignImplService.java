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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        integral.setIntegralId(user.getIntegralId());
        Date createDate = integralService.getIntegralCreateDate(integralService.getIntegralByIntegralId(integral));
        int integralNumber = differentDate(createDate, user.getSignDate()) > 1L ?
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

    /**
     * 获取两个日期之间间隔的天数
     *
     * @param oldDate       之前的签到
     * @param newDateString 新的签到
     */
    private Long differentDate(Date oldDate, String newDateString) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date newDate = sdf.parse(newDateString);
            return (newDate.getTime() - oldDate.getTime()) / (1000 * 60 * 60 * 24);
        } catch (ParseException e) {
            throw new RuntimeException("parse date to time exception" + e.getMessage());
        }
    }
}
