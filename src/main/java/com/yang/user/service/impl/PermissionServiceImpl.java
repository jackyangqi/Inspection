package com.yang.user.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yang.user.entity.Permission;
import com.yang.user.mapper.PermissionMapper;
import com.yang.user.service.IPermissionService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author laoyang
 * @since 2021-08-05
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
