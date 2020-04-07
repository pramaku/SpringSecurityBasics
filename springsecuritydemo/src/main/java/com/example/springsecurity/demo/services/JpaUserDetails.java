package com.example.springsecurity.demo.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.springsecurity.demo.models.User;

public class JpaUserDetails implements UserDetails
{
    private String userName;
    private String password;
    private int active;
    private List<GrantedAuthority> roles = new ArrayList<>();
    public JpaUserDetails(User user)
    {
        super();
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.active = user.getActive();
        GrantedAuthority auth1 =  new GrantedAuthority()
        {
            private static final long serialVersionUID = 1L;

            @Override
            public String getAuthority()
            {
                return user.getRoles();
            }
        };
        this.roles.add(auth1);
    }

    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return roles;
    }

    @Override
    public String getPassword()
    {
        return this.password;
    }

    @Override
    public String getUsername()
    {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return isActive();
    }

    private boolean isActive()
    {
        if (this.active == 1) return true;
        return false;
    }

}
