package br.com.pupposoft.fiap.sgp.ponto.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/pontos").permitAll()
                        .requestMatchers(HttpMethod.GET, "/usuarios/*/*").permitAll()
                        .requestMatchers(HttpMethod.GET, "/actuator/*/*").permitAll()
                        //.requestMatchers(HttpMethod.POST, "/users").hasRole("ADMIN")
                        .anyRequest().authenticated())
                //.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
	
//	@Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
//            throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
	
}
