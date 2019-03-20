package com.akademia.kodu.AplikacjaSpring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
@Override
    public void configure(HttpSecurity security)throws Exception{
        security.authorizeRequests()
                .antMatchers("/footballers").hasAnyRole("USER","ADMIN")
                .antMatchers("/footballer").hasAnyRole("ADMIN")
                .anyRequest().authenticated().and().formLogin().defaultSuccessUrl("/footballers");
    }

    @Autowired
    public void securityUsers(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder.inMemoryAuthentication().withUser("user1").password("user1").roles("USER")
                .and().withUser("user2").password("user2").roles("ADMIN");
    }
}
