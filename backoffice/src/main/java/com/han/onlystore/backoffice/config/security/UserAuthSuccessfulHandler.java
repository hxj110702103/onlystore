package com.han.onlystore.backoffice.config.security;
import com.han.onlystore.backoffice.Application;
import com.han.onlystore.base.model.account.Member;
import com.han.onlystore.base.service.account.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

/**
 * Created by apple on 2017/3/5.
 */
@Component
public class UserAuthSuccessfulHandler
        implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {

    @Autowired
    private MemberService memberService;

    @Override
    public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event) {
        Object principal = event.getAuthentication().getPrincipal();
        if (principal instanceof OnlyStoreUserDetails) {
            Long memberDbId = ((OnlyStoreUserDetails) principal).getMemberDbId();
            Member member = memberService.getById(memberDbId);
            if (member == null) {
               Application.logger
                        .warn("Unknown user login attempt: {}", principal);
            }
            else {
                member.setLockedOutUntil(null);
                member.setFailedLogins(0);
//                member.setLastAccess(DateUtil.now());最后登录时间
                memberService.updateForAuthLoginInfo(member);
            }
        }
    }

}

