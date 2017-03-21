package com.han.onlystore.biz.mapper.account;

import com.han.onlystore.base.model.account.Member;
import com.han.onlystore.biz.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by apple on 2017/2/18.
 */
@Mapper
public interface MemberMapper extends BaseMapper<Member>{

    void updateForAuthLoginInfo(Member member);
}
