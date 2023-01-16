package com.developersCorner.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {

   private final JwtAuthenticationFilter jwtAuthFilter;
   private final AuthenticationProvider authenticationProvider;
   
   public AppSecurityConfig(JwtAuthenticationFilter jwtFilter, AuthenticationProvider authProvider) {
	   this.jwtAuthFilter = jwtFilter;
	   this.authenticationProvider = authProvider;
   }
   
   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
     http
	     .csrf()
	     .disable()
	     .authorizeRequests()
	     .antMatchers("/auth/**")
	     .permitAll()
	     .anyRequest()
	     .authenticated()
	     .and()
	     .sessionManagement()
	     .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	     .and()
	     .authenticationProvider(authenticationProvider)
	     .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

     return http.build();
   }
}