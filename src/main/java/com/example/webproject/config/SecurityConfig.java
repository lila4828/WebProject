package com.example.webproject.config;

import com.example.webproject.service.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Autowired
    private UserSecurityService boardUserDetailsService;
    //spring security 5.0 사용
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/Login")
                .defaultSuccessUrl("/", true) //로그인 성공시 이동 url
                .and()
                .logout()
                .logoutUrl("/Logout")
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/Login")
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/")
                .and()
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .antMatchers("/", "/Login").permitAll()
                                .antMatchers("/admin/**").hasAuthority("ADMIN")
                                .antMatchers("/manager/**").hasAuthority("MANAGER")
                                .anyRequest().authenticated() //그 외 request는 모두 authenticated되어야함
                )
                .csrf().disable()
                .exceptionHandling(exceptionHandling ->
                        exceptionHandling
                                .accessDeniedPage("/accessDenied")
                )
                .userDetailsService(boardUserDetailsService);
        return http.build();
    }
    //패스워드 암호화 처리
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}