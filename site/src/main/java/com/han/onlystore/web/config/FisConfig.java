package com.han.onlystore.web.config;

import com.baidu.fis.servlet.MapListener;
import com.baidu.fis.velocity.spring.FisBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;

/**
 * Created by Amy on 2017/4/16.
 */
@Configuration
public class FisConfig {

    @Bean
    public FisBean fisBean() {
        return new FisBean();
    }

    @Bean
    public MapListener mapListener() {
        return new MapListener();
    }

    @Bean
    public Filter characterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }
}
