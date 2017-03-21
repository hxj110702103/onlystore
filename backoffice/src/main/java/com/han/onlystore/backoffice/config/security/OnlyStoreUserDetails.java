package com.han.onlystore.backoffice.config.security;

import com.han.onlystore.base.model.account.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;

/**
 * Created by apple on 2017/3/5.
 */
public class OnlyStoreUserDetails implements UserDetails {

    private Collection<GrantedAuthority> authorities;

    private Long memberDbId;

    private String username;

    private String password;

    private boolean enabled;

    private boolean locked;

    private boolean screenLocked;

    public OnlyStoreUserDetails(Member member) {
        this.memberDbId = member.getId();
        this.username = member.getMemberName();
        this.password = member.getPassword();
        this.enabled = !member.getDeleted();
        this.locked = member.getLockedOutUntil() != null && member.getLockedOutUntil().after(new Date());
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return !this.locked;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public Long getMemberDbId() {
        return memberDbId;
    }

    public void setMemberDbId(Long memberDbId) {
        this.memberDbId = memberDbId;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isScreenLocked() {
        return screenLocked;
    }

    public void setScreenLocked(boolean screenLocked) {
        this.screenLocked = screenLocked;
    }
}
