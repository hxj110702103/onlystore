package com.han.onlystore.biz.service.account.impl;

import com.han.onlystore.base.model.account.Member;
import com.han.onlystore.base.service.account.MemberService;
import com.han.onlystore.biz.mapper.account.MemberMapper;
import com.han.onlystore.biz.utils.JavaMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

/**
 * Created by apple on 2017/2/19.
 */
@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private JavaMail javaMail;

    public void create(Member member) {
        memberMapper.create(member);
    }

    public Member getById(Long id) {
        return memberMapper.findById(id);
    }

    public  Member findByUsername(String username) {
        Member member = new Member();
        member.setMemberName(username);
        try {
            javaMail.sendMail("", "");
        } catch (Exception e) {
            e.printStackTrace();
        }



        return memberMapper.findOne(member);
    }

    public void updateForAuthLoginInfo(Member member) {
        memberMapper.updateForAuthLoginInfo(member);
    }

}
