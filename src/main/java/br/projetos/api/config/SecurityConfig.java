package br.projetos.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration  
@EnableWebSecurity  
@EnableWebMvc 
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override  
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {  
        auth.inMemoryAuthentication()  
                .withUser("admin")  
                .password("admin")  
                .roles("ROLE");  
    }  
  
    @Override  
    protected void configure(HttpSecurity http) throws Exception {  
  
        http  
                .authorizeRequests()                
                .anyRequest().authenticated()  
                .and()  
                .httpBasic().and()  
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)  
                .and()  
                .csrf().disable()  
                .addFilterBefore(new CORSFilter(), ChannelProcessingFilter.class);  
    }  
}
