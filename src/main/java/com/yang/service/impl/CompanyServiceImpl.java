package com.yang.service.impl;

import com.yang.entity.Company;
import com.yang.mapper.CompanyMapper;
import com.yang.service.ICompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jack杨
 * @since 2021-09-22
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements ICompanyService {

}
