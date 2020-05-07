package com.example.ERP_IT_Comany.security;


import com.example.ERP_IT_Comany.entity.Employer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {

    private Employer employer;

    public UserPrincipal(Employer employer) {
        this.employer = employer;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + "USER" +
                "");
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.employer.getHashPassword();
    }

    @Override
    public String getUsername() {
        return this.employer.geteMail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}