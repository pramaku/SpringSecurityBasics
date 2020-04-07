package com.example.springsecurity.demo.services;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class DummyUserDetails implements UserDetails
{
    private static final long serialVersionUID = 1L;

    private String userName;
    
    public DummyUserDetails(String userName)
    {
        super();
        this.userName = userName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        GrantedAuthority auth1 =  new GrantedAuthority()
        {
            @Override
            public String getAuthority()
            {
                return "ROLE_USER";
            }
        };
        
        GrantedAuthority auth2 =  new GrantedAuthority()
        {
            @Override
            public String getAuthority()
            {
                return "ROLE_ADMIN";
            }
        };

        return Arrays.asList(auth1, auth2);
    }

    @Override
    public String getPassword()
    {
        return "pass";
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
        return true;
    }

}
