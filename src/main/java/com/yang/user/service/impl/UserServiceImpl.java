package com.yang.user.service.impl;

import com.yang.user.entity.User;
import com.yang.user.mapper.UserMapper;
import com.yang.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author jack杨
 * @since 2021-09-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
