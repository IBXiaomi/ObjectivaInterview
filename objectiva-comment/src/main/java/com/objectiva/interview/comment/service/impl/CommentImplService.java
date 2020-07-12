package com.objectiva.interview.comment.service.impl;

import com.objectiva.interview.comment.service.CommentService;
import com.objectiva.interview.entity.Integral;
import com.objectiva.interview.entity.User;
import com.objectiva.interview.integral.common.BaseIntegralService;
import com.objectiva.interview.integral.service.IntegralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 评论获取积分
 *
 * @author 吧嘻小米
 * @date 2020/07/09
 */
@Service
public class CommentImplService extends BaseIntegralService implements CommentService {

    /**
     * 每条评论获取的积分
     */
    private static final int NUMBER = 5;


    /**
     * 评论获取积分，并设置过期时间
     *
     * @param userComment 用户评论数
     * @param integral    积分id
     */
    public void getIntegralFromComment(User userComment, Integral integral) {
        int integralNumber = userComment.getCommentNumber() * NUMBER;
        super.addIntegral(integral, new BigDecimal(String.valueOf(integralNumber)));
    }

    /**
     * 设置评论积分过期时间
     *
     * @param integral       积分
     * @param expirationTime 过期时间
     */
    public void setIntegralExpirationDate(Integral integral, int expirationTime) {
        super.setIntegralExpirationDate(integral, 2);
    }
}
