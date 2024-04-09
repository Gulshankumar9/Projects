package com.eazybytes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        //csrf protection is disabled now to do section 3.
        /*http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
                .requestMatchers("/notices", "/contact", "/register").permitAll()
                .and().formLogin()
                .and().httpBasic();
        return http.build();*/

        http.csrf(csrf -> csrf.disable()).authorizeRequests(authorize -> authorize
                    .requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
                    .requestMatchers("/notices", "/contact","/register").permitAll()).formLogin(withDefaults())
            .httpBasic(withDefaults());
        return http.build();

    }


    //can use when there default tables are used, and this bean is commented because we are defining our own custom
    // code.
    /*@Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }*/

    //treat my passwords as plain text and start the authentication.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}