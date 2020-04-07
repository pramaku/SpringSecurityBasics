package com.example.springsecurity.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController
{
    @GetMapping("/")
    public String home()
    {
        return "<h1>Welcome</h1>  <br><br> <a href=\"/logout\">logout</a>";
    }

    @GetMapping("/user")
    public String welcomeUser()
    {
        return "<h1>Welcome To User page</h1> <br><br> <a href=\"/logout\"><h1>logout</h1></a>";
    }

    @GetMapping("/admin")
    public String welcomeAdmin()
    {
        return "<h1>Welcome To Admin page</h1>  <br><br> <a href=\"/logout\"><h1>logout</h1></a>";
    }
}
