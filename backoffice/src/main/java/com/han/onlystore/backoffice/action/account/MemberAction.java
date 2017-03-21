package com.han.onlystore.backoffice.action.account;

import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethodType;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreResult;
import com.han.onlystore.base.model.account.Member;
import com.han.onlystore.base.service.account.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by apple on 2017/2/19.
 */
@Component
public class MemberAction {
    @Autowired
    private MemberService memberService;

    @ExtDirectMethod(ExtDirectMethodType.STORE_READ)
    public ExtDirectStoreResult<Member> search(ExtDirectStoreReadRequest request) throws Exception{
        Member member = memberService.getById(1L);

        return new ExtDirectStoreResult<Member>(member);
    }
}
