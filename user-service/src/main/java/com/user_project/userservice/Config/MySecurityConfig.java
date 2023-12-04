package com.user_project.userservice.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                //.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                //.and()
                .authorizeRequests()
                .antMatchers("/users/**").hasRole("ADMIN") // User-based authenction - permit only for NORMAL

                //.antMatchers().permitAll() // User-based authenction - permit only for NORMAL
                //.antMatchers("/public/**").hasRole("NORMAL") // User-based authenction - permit only for NORMAL
                //.antMatchers("/users/**").hasRole("ADMIN") // User-based authenction - permit only for NORMAL
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic(); // this is use basic authentication >>


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("loki").password(this.passwordEncoder().encode("loki1234")).roles("ADMIN");
        auth.inMemoryAuthentication().withUser("rohit").password(this.passwordEncoder().encode("rohit1234")).roles("NORMAL");
    }

    //ROLE - High level overview
    //Normal - role can only Read means - normal's authrity -> Read only
    // ADMIN - role can  Read & Write means - normal's authrity -> Read ,Write

    /*@Bean
    public PasswordEncoder  passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }*/

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }


}
