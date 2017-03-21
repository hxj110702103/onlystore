package com.han.onlystore.backoffice.action.common;

import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import com.han.onlystore.backoffice.config.security.OnlyStoreUserDetails;
import com.han.onlystore.base.model.account.Member;
import com.han.onlystore.base.service.account.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;

/**
 * Created by Amy on 2017/3/20.
 */
@Component
public class SecurityAction {
    @Autowired
    private MemberService memberService;

    @ExtDirectMethod
    public Member getLoginedUser(@AuthenticationPrincipal OnlyStoreUserDetails onlyStoreUserDetails) {
        if(onlyStoreUserDetails != null) {
            return  memberService.getById(onlyStoreUserDetails.getMemberDbId());
        }

        return null;
    }
}
