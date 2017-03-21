package com.han.onlystore.backoffice.config;

import ch.ralscha.extdirectspring.util.JsonHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.han.onlystore.base.common.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.nio.file.AccessDeniedException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Amy on 2017/2/21.
 */
@Configuration
public class WebConfig {
    @Autowired
    private Environment environment;

    @Bean
    public ch.ralscha.extdirectspring.controller.Configuration configuration() {
        ch.ralscha.extdirectspring.controller.Configuration config = new ch.ralscha.extdirectspring.controller.Configuration();
        config.setDefaultExceptionMessage("test exception msg");
        Map<Class<?>, String> etm = new HashMap<Class<?>, String>();
        etm.put(AccessDeniedException.class, "accessdenied");
        etm.put(SQLException.class, "数据库异常");
        etm.put(ClassNotFoundException.class, "无法找到指定的类");
        config.setExceptionToMessage(etm);
        config.setMaxRetries(0);

        //测试时，要给出全路径的URL
        if(!environment.acceptsProfiles(Constants.PROFILE_DEV)) {
            config.setFullRouterUrl(true);
        }

        config.setSendExceptionMessage(true);
        config.setSendStacktrace(true);
        return config;
    }

    @Bean
    public JsonHandler jsonHandler(ObjectMapper objectMapper) {
        JsonHandler jh = new JsonHandler();
        jh.setMapper(objectMapper);
        return jh;
    }
}
