package com.han.onlystore.backoffice.config.security;

import com.han.onlystore.base.model.account.Member;
import com.han.onlystore.base.service.account.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by apple on 2017/3/5.
 */
@Component
public class OnlyStoreUserDetailsService implements UserDetailsService {

    @Autowired
    private MemberService memberService;

    public OnlyStoreUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberService.findByUsername(username);

        if(member == null) {
            throw new UsernameNotFoundException(username);
        }

        return new OnlyStoreUserDetails(member);
    }

}
