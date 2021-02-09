package com.example.postgresqltest.service.impl;

import com.example.postgresqltest.entity.Cities;
import com.example.postgresqltest.mapper.CitiesMapper;
import com.example.postgresqltest.service.ICitiesService;
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
public class CitiesServiceImpl extends ServiceImpl<CitiesMapper, Cities> implements ICitiesService {

}
