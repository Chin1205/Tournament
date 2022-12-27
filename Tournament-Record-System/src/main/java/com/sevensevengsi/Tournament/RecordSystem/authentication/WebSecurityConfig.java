package com.sevensevengsi.Tournament.RecordSystem.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Bean
    public UserDetailsService userDetailsService() {
        return new MyUserDetailsService();
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/team").hasAnyRole("ADMIN", "MANAGER")
                .antMatchers("/tournament").hasAnyRole("ADMIN", "MANAGER", "FAN")
                .antMatchers("/game").hasRole("ADMIN")
                .antMatchers("/page/manager").hasRole("MANAGER")
                .antMatchers("/page/official").hasRole("OFFICIAL")
                .antMatchers("/page/admin").hasRole("ADMIN")
                .antMatchers("/page/fan").hasRole("FAN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .permitAll()
               .defaultSuccessUrl("/home").and()
               .logout().logoutSuccessUrl("/login")
                .and()
               .exceptionHandling().accessDeniedPage("/access_denied");
      /*  http.authorizeRequests().antMatchers("/api/**").permitAll()
                .antMatchers("/page/manager").hasRole("MANAGER")
                .antMatchers("/page/official").hasRole("OFFICIAL")
                .antMatchers("/page/admin").hasRole("ADMIN")
                .antMatchers("/page/fan").hasRole("FAN")
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied");*/
    }
}
