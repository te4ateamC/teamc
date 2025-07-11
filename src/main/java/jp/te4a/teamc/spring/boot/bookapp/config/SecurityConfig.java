package jp.te4a.teamc.spring.boot.bookapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jp.te4a.teamc.spring.boot.bookapp.service.LoginUserDetailsService;

@Configuration
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
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        /*http //セキュリティ無効化
            .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
            .csrf(csrf -> csrf.disable());
        return http.build();*/
        /*http.formLogin(login -> login
                .loginProcessingUrl("/login")
                .loginPage("/loginForm")
                .defaultSuccessUrl("/books", true)
                .failureUrl("/loginForm?error")
                .usernameParameter("username").passwordParameter("password")
                .permitAll()).logout(logout -> logout
                        .logoutSuccessUrl("/loginForm"))
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/webjars/**", "/css/**").permitAll()
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/users").permitAll()
                        .requestMatchers("/users/create").permitAll()
                        .anyRequest().authenticated());

                        
        return http.build();*/

        http
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/css/**", "/login", "/loginForm").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(login -> login
                .loginPage("/loginForm") // login.htmlを /loginForm にマッピング
                .loginProcessingUrl("/login") // フォームのaction先
                .usernameParameter("user")    // HTMLのname="user"
                .passwordParameter("password")// HTMLのname="password"
                .defaultSuccessUrl("/order-history", true) // ✅ログイン後の遷移先
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
}