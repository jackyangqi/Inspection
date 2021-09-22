package com.yang.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yang.entity.Company;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jack杨
 * @since 2021-09-22
 */
@Mapper
public interface CompanyMapper extends BaseMapper<Company> {

}
