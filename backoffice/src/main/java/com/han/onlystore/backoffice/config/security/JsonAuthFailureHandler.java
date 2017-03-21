package com.han.onlystore.backoffice.config.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by apple on 2017/3/5.
 */
public class JsonAuthFailureHandler implements AuthenticationFailureHandler {
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {
        response.getWriter().print("{\"success\": false}");
        response.getWriter().flush();
    }

}
