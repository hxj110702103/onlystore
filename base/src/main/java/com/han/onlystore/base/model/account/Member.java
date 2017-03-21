package com.han.onlystore.base.model.account;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.han.onlystore.base.model.AbstractPersistable;

import java.util.Date;

/**
 * Created by apple on 2017/2/18.
 */
public class Member extends AbstractPersistable {
    private static final long serialVersionUID = -2609422113996177581L;

    //会员账号
    private String  memberName;

    //Email
    private String email;

    //手机号
    private String mobile;

    //登录密码
    private String password;

    //登录类型，"common普通登录 trustlogin 信任登录"
    private LoginType loginType;

    //会员等级ID
    private Long gradeId;

    //真实姓名(公司名称,淘宝账号,b2c商城真实姓名)
    private String realName;

    //生日
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss Z")
    private Date birthday;

    //性别
    private  SexType sex;

    //注册IP
    private String regIp;

    //注册时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date regTime;

    //是否有效
    private Boolean deleted;

    //失败登陆次数
    private Integer failedLogins;

    //锁定截止时间
    private Date lockedOutUntil;

    //密码重置令牌
    private String passwdResetToken;

    //密码重置令牌有效时间
    private Date passwdResetTokenValidUntil;

    //邮箱激活令牌
    private String activeToken;

    //是否通过邮箱验证
    private Boolean emailVerify;

    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss Z")
    private Date createTime;

    //更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss Z")
    private Date updateTime;

    public Member() {

    }

    public Member(String memberName, String email, String mobile, String password, LoginType loginType, Long gradeId, String realName, Date birthday, SexType sex, String regIp, Date regTime, Boolean deleted) {
        this.memberName = memberName;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.loginType = loginType;
        this.gradeId = gradeId;
        this.realName = realName;
        this.birthday = birthday;
        this.sex = sex;
        this.regIp = regIp;
        this.regTime = regTime;
        this.deleted = deleted;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public SexType getSex() {
        return sex;
    }

    public void setSex(SexType sex) {
        this.sex = sex;
    }

    public String getRegIp() {
        return regIp;
    }

    public void setRegIp(String regIp) {
        this.regIp = regIp;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Integer getFailedLogins() {
        return failedLogins;
    }

    public void setFailedLogins(Integer failedLogins) {
        this.failedLogins = failedLogins;
    }

    public Date getLockedOutUntil() {
        return lockedOutUntil;
    }

    public void setLockedOutUntil(Date lockedOutUntil) {
        this.lockedOutUntil = lockedOutUntil;
    }

    public String getPasswdResetToken() {
        return passwdResetToken;
    }

    public void setPasswdResetToken(String passwdResetToken) {
        this.passwdResetToken = passwdResetToken;
    }

    public Date getPasswdResetTokenValidUntil() {
        return passwdResetTokenValidUntil;
    }

    public void setPasswdResetTokenValidUntil(Date passwdResetTokenValidUntil) {
        this.passwdResetTokenValidUntil = passwdResetTokenValidUntil;
    }

    public String getActiveToken() {
        return activeToken;
    }

    public void setActiveToken(String activeToken) {
        this.activeToken = activeToken;
    }

    public Boolean getEmailVerify() {
        return emailVerify;
    }

    public void setEmailVerify(Boolean emailVerify) {
        this.emailVerify = emailVerify;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
