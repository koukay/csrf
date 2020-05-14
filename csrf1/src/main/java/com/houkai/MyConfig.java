package com.houkai;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class MyConfig extends WebSecurityConfigurerAdapter {
    //全栈post
    //下发hash值(全栈hash)
    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    //所有请求都需要校验
                    .anyRequest()
                    .authenticated()
            .and()
            .formLogin().loginPage("/login.html")

            .loginProcessingUrl("/login").permitAll()
            .failureUrl("/login.html?error")
                    .defaultSuccessUrl("/ok.html",true).permitAll()
                    .passwordParameter("oo")
                    .usernameParameter("xx")

                    .failureHandler(new AuthenticationFailureHandler(){
                @Override
                public void onAuthenticationFailure(HttpServletRequest httpServletRequest,
                                                    HttpServletResponse httpServletResponse,
                                                    AuthenticationException e) throws IOException, ServletException {
                    e.printStackTrace();
                    httpServletRequest.getRequestDispatcher(httpServletRequest.getRequestURL().toString()).forward(httpServletRequest,httpServletResponse);
                }
            })
                    //类似标签子标签的结构
//                .authorizeRequests()
//                .antMatchers("").denyAll()
                    //默认 所有的post请求 都会拦截
                .and()
                .csrf()
                .csrfTokenRepository(new HttpSessionCsrfTokenRepository());
    }

    //seesion 登录 高并发 -> jwt
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        String pwd1 = new BCryptPasswordEncoder().encode("123");
        String pwd2 = new BCryptPasswordEncoder().encode("123");
        System.out.println(pwd1);
        System.out.println(pwd2);
        auth.
                inMemoryAuthentication()
                    .withUser("123").password(pwd1).roles("admin")
                .and()
                    .withUser("321").password("321").roles("user")
                ;
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
