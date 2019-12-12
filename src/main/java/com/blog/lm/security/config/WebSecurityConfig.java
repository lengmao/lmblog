package com.blog.lm.security.config;

import com.blog.lm.security.handle.AuthEntryPointHandle;
import com.blog.lm.security.handle.AuthRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.blog.lm.security.handle.AuthRequestFilter.API_PATH;

/**
 * @Author xus
 * @Date 2019/11/6 13:54
 * @Description TODO
 **/
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AuthRequestFilter authRequestFilter;

    @Autowired
    AuthEntryPointHandle authEntryPointHandle;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/oauth/**", "/api/**",API_PATH,"/webjars/**","/swagger-resources/**","/v2/**","/doc.html").permitAll()
                .anyRequest().authenticated()
                .and().exceptionHandling().authenticationEntryPoint(authEntryPointHandle).accessDeniedHandler(authEntryPointHandle)
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(authRequestFilter, UsernamePasswordAuthenticationFilter.class);
        http.csrf().disable();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * https://spring.io/blog/2017/11/01/spring-security-5-0-0-rc1-released#password-storage-updated
     * Encoded password does not look like BCrypt
     *
     * @return PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
