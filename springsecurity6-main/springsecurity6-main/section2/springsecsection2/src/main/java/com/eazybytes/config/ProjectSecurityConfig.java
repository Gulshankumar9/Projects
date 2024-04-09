package com.eazybytes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        /**
         *  Below is the custom security configurations
         */

        /*code with spring version 3.0.2*/
        /*http.authorizeHttpRequests().requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards")
        .authenticated()
            .requestMatchers("/notices", "/contact").permitAll().and().formLogin().and().httpBasic();
        return http.build();*/

        /*code upgraded for spring version 3.1.10*/
        http.authorizeRequests(authorize -> authorize
                    .requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
                    .requestMatchers("/notices", "/contact").permitAll()).formLogin(withDefaults())
            .httpBasic(withDefaults());

        return http.build();


    }

}
/**
 * Configuration to deny all the requests
 * <p>
 * Configuration to permit all the requests
 * <p>
 * Configuration to permit all the requests
 * <p>
 * Configuration to permit all the requests
 * <p>
 * Configuration to permit all the requests
 * <p>
 * Configuration to permit all the requests
 * <p>
 * Configuration to permit all the requests
 * <p>
 * Configuration to permit all the requests
 * <p>
 * Configuration to permit all the requests
 * <p>
 * Configuration to permit all the requests
 * <p>
 * Configuration to permit all the requests
 * <p>
 * Configuration to permit all the requests
 * <p>
 * Configuration to permit all the requests
 * <p>
 * Configuration to permit all the requests
 * <p>
 * Configuration to permit all the requests
 * <p>
 * Configuration to permit all the requests
 * <p>
 * Configuration to permit all the requests
 * <p>
 * Configuration to permit all the requests
 * <p>
 * Configuration to permit all the requests
 * <p>
 * Configuration to permit all the requests
 * <p>
 * Configuration to permit all the requests
 */
        /*http.authorizeHttpRequests().anyRequest().denyAll()
                .and().formLogin()
                .and().httpBasic();
        return http.build();*/

/**
 *  Configuration to permit all the requests
 */
        /*http.authorizeHttpRequests().anyRequest().permitAll()
                .and().formLogin()
                .and().httpBasic();
        return http.build();*/