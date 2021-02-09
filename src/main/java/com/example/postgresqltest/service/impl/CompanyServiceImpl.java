package com.example.postgresqltest.service.impl;

import com.example.postgresqltest.entity.Company;
import com.example.postgresqltest.mapper.CompanyMapper;
import com.example.postgresqltest.service.ICompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ning
 * @since 2021-02-08
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements ICompanyService {

}
