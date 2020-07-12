package com.objectiva.interview.comment.service;

import com.objectiva.interview.entity.Integral;
import com.objectiva.interview.entity.User;

/**
 * 评论获取积分
 *
 * @author 吧嘻小米
 * @date 2020/07/09
 */
public interface CommentService  {

    /**
     * 评论获取积分
     *
     * @param user     用户
     * @param integral 积分
     */
    void getIntegralFromComment(User user, Integral integral);

    /**
     * 设置评论积分过期时间
     *
     * @param integral       积分
     * @param expirationTime 过期时间
     */
    void setIntegralExpirationDate(Integral integral, int expirationTime);
}
