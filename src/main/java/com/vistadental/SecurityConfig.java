package com.vistadental;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("sebastian")
                    .password("{noop}123")
                    .roles("ADMIN","VENDEDOR","USER")
                .and()
                .withUser("david")
                    .password("{noop}456")
                    .roles("VENDEDOR","USER");
                
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/paciente/nuevo",        "/paciente/guardar", 
                             "/paciente/modificar/**", "/paciente/eliminar/**")
                    .hasRole("ADMIN")
                .antMatchers("/paciente/listado")
                    .hasAnyRole("ADMIN","VENDEDOR")                
                .antMatchers("/paciente/**")
                    .permitAll()
                .and()
                    .formLogin()
                    .loginPage("/login")
                .and()
                    .exceptionHandling().accessDeniedPage("/errores/403");
    } 

    
}

