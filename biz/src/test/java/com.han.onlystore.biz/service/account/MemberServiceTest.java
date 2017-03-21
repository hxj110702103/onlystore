package com.han.onlystore.biz.service.account;

import com.han.onlystore.base.model.account.LoginType;
import com.han.onlystore.base.model.account.Member;
import com.han.onlystore.base.model.account.SexType;
import com.han.onlystore.base.service.account.MemberService;
import com.han.onlystore.biz.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by apple on 2017/2/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class MemberServiceTest {
    @Autowired
    private MemberService memberService;

    @Test
    public void create() {
        Member member = new Member("admin", "923575965@qq.com", "13817556575", "111111", LoginType.COMMON,
                1L, "韩秀娟", new Date(), SexType.FEMALE, "127.0.0.1", new Date(), false);

        memberService.create(member);
    }
}
