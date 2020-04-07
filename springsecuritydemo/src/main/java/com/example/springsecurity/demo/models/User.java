package com.example.springsecurity.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User
{
    @Id
    private long id;

    @Column(name="user_name")
    private String userName;

    private String password;

    private short active;

    private String roles;

    public User(long id, String userName, String password, short active)
    {
        super();
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.active = active;
    }

    public User()
    {
        super();
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public short getActive()
    {
        return active;
    }

    public void setActive(short active)
    {
        this.active = active;
    }

    public String getRoles()
    {
        return roles;
    }

    public void setRoles(String role)
    {
        this.roles = role;
    }
}
