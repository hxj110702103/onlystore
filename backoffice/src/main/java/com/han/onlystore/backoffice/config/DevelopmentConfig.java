package com.han.onlystore.backoffice.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Collections;

/**
 * Created by Amy on 2017/2/21.                                                  ccccomsdfsaf
 */
@Configuration
public class DevelopmentConfig extends WebMvcConfigurerAdapter {
    @Bean
    public FilterRegistrationBean corsFilter() {
        FilterRegistrationBean filter = new FilterRegistrationBean();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Collections.singletonList(CorsConfiguration.ALL));
        config.setAllowedMethods(Collections.singletonList(CorsConfiguration.ALL));
        config.setAllowedHeaders(Collections.singletonList(CorsConfiguration.ALL));
        config.setAllowCredentials(true);
        filter.setFilter(new CorsFilter(r -> config));
        filter.setUrlPatterns(Collections.singleton("/*"));
        filter.setOrder(SecurityProperties.DEFAULT_FILTER_ORDER - 1);
        return filter;
    }

}
