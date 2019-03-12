/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
    
package com.miage.security.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {


  //users configuration
      @Override
      protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication().withUser("miage").password("password").roles("USER");
            auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
      }



  //--------------------------------------------
  // Rule 1 : security for all API
  //--------------------------------------------
  /*@Override protected void configure(HttpSecurity http) throws Exception {    
    http.httpBasic().
      realmName("spring-app").
      and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
      and().csrf().disable().
      authorizeRequests().anyRequest().fullyAuthenticated().and().
      httpBasic();
  }*/

  //--------------------------------------------
      // Rule 2 : security based on URL
  //--------------------------------------------
    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().
                realmName("spring-app").
                and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
                and().csrf().disable().
                authorizeRequests().antMatchers("/rest/**").fullyAuthenticated().and().httpBasic();
    }*/



  //--------------------------------------------
      // Rule 3 : security based on ROLE
  //--------------------------------------------
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().
           realmName("spring-app").
           and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
           and().csrf().disable().
           authorizeRequests().antMatchers("/rest/**").hasAnyRole("ADMIN").anyRequest().fullyAuthenticated().and()
                       .httpBasic();
    }



    @Bean
    public NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

}

