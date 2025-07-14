package jp.te4a.teamc.spring.boot.bookapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jp.te4a.teamc.spring.boot.bookapp.service.LoginUserDetailsService;

/*@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private LoginUserDetailsService loginUserDetailsSrevice;

    public void configureAuthenticationManager(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(loginUserDetailsSrevice).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

     @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder)
            throws Exception {
        AuthenticationManagerBuilder auth = http.getSharedObject(AuthenticationManagerBuilder.class);
        auth.inMemoryAuthentication()
            .withUser("testuser")
            .password(passwordEncoder.encode("testpass"))
            .roles("USER");
        return auth.build();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/css/**", "/login", "/loginForm").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(login -> login
                .loginPage("/loginForm")
                .loginProcessingUrl("/login")
                .usernameParameter("user")
                .passwordParameter("password")
                .defaultSuccessUrl("/order-history", true)
                .failureUrl("/loginForm?error")
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/loginForm?logout")
                .permitAll()
            )
            .csrf(csrf -> csrf.disable());

        return http.build();
    }
}*/

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/css/**", "/login", "/loginForm").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(login -> login
                .loginPage("/loginForm")
                .loginProcessingUrl("/login")
                .usernameParameter("user")
                .passwordParameter("password")
                .defaultSuccessUrl("/order-history", true)
                .failureUrl("/loginForm?error")
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/loginForm?logout")
                .permitAll()
            )
            .csrf(csrf -> csrf.disable());

        // inMemoryユーザの設定をここでやる
        AuthenticationManagerBuilder authBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authBuilder.inMemoryAuthentication()
            .withUser("testuser")
            .password(passwordEncoder().encode("testpass"))
            .roles("USER");

        return http.build();
    }
}
