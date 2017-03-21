package com.han.onlystore.backoffice.config.security;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

/**
 * Created by apple on 2017/3/5.
 */
@Component
public class UserAuthErrorHandler
    implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {

    }
}
