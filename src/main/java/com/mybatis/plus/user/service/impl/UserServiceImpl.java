package com.mybatis.plus.user.service.impl;

import com.mybatis.plus.user.entity.User;
import com.mybatis.plus.user.mapper.UserMapper;
import com.mybatis.plus.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-12-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
