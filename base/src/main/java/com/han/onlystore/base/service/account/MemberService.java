package com.han.onlystore.base.service.account;

import com.han.onlystore.base.model.account.Member;
import org.springframework.messaging.MessagingException;

/**
 * Created by apple on 2017/2/19.
 */
public interface MemberService {
    void create(Member member);

    Member getById(Long id);

    Member findByUsername(String username);

    /**
     * 更新用户登录信息
     * 1.登录失败时，更新登录次数以及上锁时间
     * 2.登录成功时，登录次数置为0，上锁时间置为null
     * @param member
     */
    void updateForAuthLoginInfo(Member member);
}
