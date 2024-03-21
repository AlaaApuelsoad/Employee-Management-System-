package com.qnetemployee.qnetdemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class QnetSecurity {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery
                ("select user_id, pw, active from members where user_id=?");

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery
                ("select user_id,role from roles where user_id=?");

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("/").hasAnyRole("EMPLOYEE","MANAGER","ADMIN")
                        .requestMatchers("/employeesList").hasRole("EMPLOYEE")
                        .requestMatchers("/system/list").hasRole("ADMIN")
                        .requestMatchers("/system/managersView").hasRole("MANAGER")
                        .anyRequest().authenticated()

        )
                .exceptionHandling(configurer->
                        configurer.accessDeniedPage("/access-denied"))
                .formLogin(form->
                        form
                                .loginPage("/showLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                )
                .logout(logout -> logout.permitAll()
                );

        return http.build();
    }
}
