package com.example.hotel.security;


import com.example.hotel.service.GuestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final GuestService guestService;
    private final PasswordEncoder passwordEncoder;
    public SecurityConfig(GuestService guestService, PasswordEncoder passwordEncoder) {
        this.guestService = guestService;
        this.passwordEncoder=passwordEncoder;
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return guestService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(guestService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .formLogin(form -> {
                    form.loginPage("/login").permitAll().defaultSuccessUrl("/home", true);
                })
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/register", "/css/**", "/js/**", "/home").permitAll();
                    auth.anyRequest().authenticated();
                })
                .sessionManagement(session -> session
                        .maximumSessions(1)
                        .expiredUrl("/login?expired=true"))
                .build();
    }
}
