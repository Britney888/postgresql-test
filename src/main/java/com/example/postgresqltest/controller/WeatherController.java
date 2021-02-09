package com.example.postgresqltest.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.postgresqltest.entity.Weather;
import com.example.postgresqltest.service.IWeatherService;
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
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2021-02-08
 */
@Slf4j
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    IWeatherService weatherService;

    /**
     * @Description //TODO 条件查询
     * @Date 10:07 2021/2/9
     * @Param
     * @return com.example.postgresqltest.utils.HttpResult
     **/
    @RequestMapping("/getWeather")
    public HttpResult getWeatherByTempLo(@RequestParam("tempLo") Integer tempLo){
        QueryWrapper<Weather> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("temp_lo", tempLo);
        Weather weather=weatherService.getOne(queryWrapper);
        return new HttpResult(weather);
    }

    /**
     * @Author ning
     * @Description //TODO 查询所有
     * @Date 10:13 2021/2/9
     * @Param
     * @return com.example.postgresqltest.utils.HttpResult
     **/
    @RequestMapping("/getAllWeather")
    public HttpResult getAllWeather(@RequestBody Map<String,String> paramMap){
        PageHelper.startPage(Integer.parseInt(paramMap.get("pageNum")),Integer.parseInt(paramMap.get("pageSize")));
        List<Weather> weathers=weatherService.list();
        PageInfo<Weather> pageInfo=new PageInfo<>(weathers);
        return new HttpResult(pageInfo);
    }

    @RequestMapping("/editWeather")
    public HttpResult editWeather(@RequestBody Map<String,String> paramMap){

        QueryWrapper<Weather> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("temp_lo", Integer.parseInt(paramMap.get("tempLo")));
        Weather weather=weatherService.getOne(queryWrapper);
        weather.setDate(LocalDate.now());
       Boolean result= weatherService.update(weather, queryWrapper);
        return new HttpResult(result);
    }

    @RequestMapping("/addWeather")
    public HttpResult addWeather(@RequestBody Weather weather){
        log.info("开始添加数据{}", JSON.toJSONString(weather));
        weather.setDate(LocalDate.now());
        Boolean result= weatherService.save(weather);
        return new HttpResult(result);
    }

}
