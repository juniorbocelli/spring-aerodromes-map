package com.juniorbocelli.xmobotscase.authentication;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.juniorbocelli.xmobotscase.core.security.config.SecurityConstants;
import com.juniorbocelli.xmobotscase.user.data.datasources.impl.UserDatasourcesLocalImpl;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class WebSecurityFilter {
    private AuthenticationManager authenticationManager;
    private JWTAuthenticationFilter jwtAuthenticationFilter;
    private JWTAuthorizationFilter jwtAuthorizationFilter;

    public WebSecurityFilter(AuthenticationManager authenticationManager,
            JWTAuthenticationFilter jwtAuthenticationFilter, JWTAuthorizationFilter jwtAuthorizationFilter) {
        this.authenticationManager = authenticationManager;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.jwtAuthorizationFilter = jwtAuthorizationFilter;
    }

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .cors(withDefaults())
                .csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL).permitAll()
                        .requestMatchers(HttpMethod.POST, SecurityConstants.LOGIN_URL).permitAll()
                        .anyRequest().authenticated())
                .addFilter(jwtAuthenticationFilter)
                .addFilter(jwtAuthorizationFilter)
                .authenticationManager(authenticationManager)
                .sessionManagement((session) -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("POST", "PUT", "GET", "OPTIONS", "DELETE", "PATCH")); // or simply
                                                                                                            // "*"
        configuration.setAllowedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
