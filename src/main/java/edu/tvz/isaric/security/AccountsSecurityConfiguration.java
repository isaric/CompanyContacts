package edu.tvz.isaric.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.h2.H2ConsoleProperties;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Order(SecurityProperties.BASIC_AUTH_ORDER - 11)
public class AccountsSecurityConfiguration extends WebSecurityConfigurerAdapter
{
    private UserDetailsService accountsUserDetailsService;

    private H2ConsoleProperties properties;

    @Autowired
    public AccountsSecurityConfiguration(
            UserDetailsService accountsUserDetailsService,
            H2ConsoleProperties properties)
    {
        this.accountsUserDetailsService = accountsUserDetailsService;
        this.properties = properties;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        String path = this.properties.getPath();
        String antPattern = (path.endsWith("/") ? path + "**" : path + "/**");

        http.authorizeRequests()
            .antMatchers("/api/login", antPattern).permitAll()
            .antMatchers("/api/companies").hasAnyAuthority("EMPLOYEE", "CLIENT")
            .antMatchers("/api/admin").hasAuthority("ADMIN")
            .and()
            .httpBasic()
            .and()
            .headers().frameOptions().sameOrigin()
            .and()
            .csrf()
            .disable()
            .userDetailsService(accountsUserDetailsService);
    }
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
