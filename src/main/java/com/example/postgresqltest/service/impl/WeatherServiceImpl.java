package com.example.postgresqltest.service.impl;

import com.example.postgresqltest.entity.Weather;
import com.example.postgresqltest.mapper.WeatherMapper;
import com.example.postgresqltest.service.IWeatherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2021-02-08
 */
@Service
public class WeatherServiceImpl extends ServiceImpl<WeatherMapper, Weather> implements IWeatherService {


}
