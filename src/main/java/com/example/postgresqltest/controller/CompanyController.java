package com.example.postgresqltest.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.postgresqltest.entity.Company;
import com.example.postgresqltest.entity.Company;
import com.example.postgresqltest.service.ICompanyService;
import com.example.postgresqltest.utils.HttpResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ning
 * @since 2021-02-08
 */
@Slf4j
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    ICompanyService companyService;
    /**
     * @Description //TODO 条件查询
     * @Date 10:07 2021/2/9
     * @Param
     * @return com.example.postgresqltest.utils.HttpResult
     **/
    @RequestMapping("/getCompany")
    public HttpResult getCompanyById(@RequestParam("id") Integer id){
        QueryWrapper<Company> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id", id);
        Company company=companyService.getOne(queryWrapper);
        return new HttpResult(company);
    }

    /**
     * @Author ning
     * @Description //TODO 查询所有
     * @Date 10:13 2021/2/9
     * @Param
     * @return com.example.postgresqltest.utils.HttpResult
     **/
    @RequestMapping("/getAllCompany")
    public HttpResult getAllCompany(@RequestBody Map<String,String> paramMap){
        PageHelper.startPage(Integer.parseInt(paramMap.get("pageNum")),Integer.parseInt(paramMap.get("pageSize")));
        List<Company> companys=companyService.list();
        PageInfo<Company> pageInfo=new PageInfo<>(companys);
        return new HttpResult(pageInfo);
    }

    @RequestMapping("/editCompany")
    public HttpResult editCompany(@RequestBody Map<String,String> paramMap){

        QueryWrapper<Company> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("temp_lo", Integer.parseInt(paramMap.get("tempLo")));
        Company company=companyService.getOne(queryWrapper);
        company.setJoinDate(LocalDate.now());
        Boolean result= companyService.update(company, queryWrapper);
        return new HttpResult(result);
    }

    @RequestMapping("/addCompany")
    public HttpResult addCompany(@RequestBody Company company){
        log.info("开始添加数据{}", JSON.toJSONString(company));
        company.setJoinDate(LocalDate.now());
        Boolean result= companyService.save(company);
        return new HttpResult(result);
    }

}

