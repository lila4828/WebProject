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
    private UserSecurityService userSecurityService;

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
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/")


                .and()
                .authorizeRequests(authorizeRequests -> authorizeRequests
                                .antMatchers("/", "/Login", "/MemberList/**", "/images/**").permitAll()
                                .antMatchers("/Admin/**").hasAuthority("ADMIN")
                                .anyRequest().authenticated()
                )
                .csrf().disable()
                .exceptionHandling(exceptionHandling ->
                        exceptionHandling
                                .accessDeniedPage("/RoleError")
                )
                .userDetailsService(userSecurityService);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}