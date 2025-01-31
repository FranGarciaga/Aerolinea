package org.example.security;

import ch.qos.logback.core.Context;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@PropertySource("classpath:application.properties")
@EnableWebSecurity
public class SecurityConfiguration {

    @Value("${api-endpoint}")
    private String endpoint;

    private JpaUserDetailsService jpaUserDetailsService;
    private Context env;

    public SecurityConfiguration(JpaUserDetailsService userDetailsService) {
        this.jpaUserDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        String endpoint = env.getProperty("api-endpoint");

            http
                .cors(withDefaults())
                .csrf(csrf -> csrf.disable())
                .formLogin(form -> form.disable())
                .logout(out -> out
                        .logoutUrl(endpoint + "/logout")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID"))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
                        .requestMatchers(endpoint).permitAll()
                        .requestMatchers(HttpMethod.POST, endpoint + "/register").permitAll()
                        .requestMatchers(endpoint + "/login").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(endpoint + "/public").permitAll()
                        .requestMatchers(endpoint + "/private").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, endpoint + "/aeropuertos").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, endpoint + "/aeropuertos").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, endpoint + "/aeropuertos/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, endpoint + "/aeropuertos/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, endpoint + "/vuelos").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, endpoint + "/vuelos").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, endpoint + "/vuelos/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, endpoint + "/vuelos/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, endpoint + "/reservas").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, endpoint + "/reservas/mis-reservas").authenticated()
                        .requestMatchers(HttpMethod.POST, endpoint + "/reservas").authenticated()
                        .requestMatchers(HttpMethod.PUT, endpoint + "/reservas").authenticated()
                        .requestMatchers(HttpMethod.DELETE, endpoint + "/reservas").authenticated()

                        .anyRequest().authenticated())
                        .userDetailsService(jpaUserDetailsService)
                        .httpBasic(withDefaults())
                        .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED));
                        http.headers(header -> header.frameOptions(frame -> frame.sameOrigin()));
                        return http.build();

    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}