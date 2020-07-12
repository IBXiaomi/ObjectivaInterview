package com.objectiva.interview.integral.dao;


import com.objectiva.interview.entity.User;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * 用户相关
 *
 * @author 吧嘻小米
 * @date 2020/07/09
 */
@Repository
public interface UserMapper {

    /**
     * 根据用户查找用户积分总额
     *
     * @param user 用户
     * @return
     */
    BigDecimal findSumIntegral(User user);

}
