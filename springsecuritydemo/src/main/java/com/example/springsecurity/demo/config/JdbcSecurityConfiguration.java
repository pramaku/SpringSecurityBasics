package com.example.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Uncomment the below annotations to use this security configuration.
 */
//@Configuration
//@EnableWebSecurity
public class JdbcSecurityConfiguration extends WebSecurityConfigurerAdapter
{
    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder authBuilder) throws Exception
    {
        authBuilder
            .jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery("select username_login,password,enabled from users_for_login where username_login=?")
            .authoritiesByUsernameQuery("select username,authority from authorities_roles where username=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
            .antMatchers("/admin").hasRole("ADMIN")
            .antMatchers("/user").hasAnyRole("ADMIN", "USER")
            .antMatchers("/").permitAll()
            .and().formLogin();

        //http.authorizeRequests().antMatchers("/h2-console/**").permitAll();
        http.csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return NoOpPasswordEncoder.getInstance();
    }
}
