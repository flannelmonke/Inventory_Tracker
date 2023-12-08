package ca.sheridan.najiahm.naji_ahmad_khalil_assignment4.sec_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/h2-console/**").permitAll()
                        .requestMatchers("/admin/**").hasAuthority("ADMIN")
                        .requestMatchers("/sales/**").hasAuthority("SALES")
                        .anyRequest().authenticated())
                .formLogin(login -> login.loginPage("/login").permitAll())
                .logout(logout -> logout
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login?logout")
                        .permitAll());
        return http.build();
    }

    @Bean
    public UserDetailsService users() {
        UserBuilder user = User.withDefaultPasswordEncoder(); // JUST AN EXAMPLE, USE ENCRYPT METHOD IN PRODUCTION
        UserDetails admin = user
                .username("userA")
                .password("aaaa")
                .authorities("ADMIN")
                .build();

        UserDetails guest = user
                .username("userB")
                .password("bbbb")
                .authorities("SALES")
                .build();
        UserDetails all = user
                .username("userC")
                .password("cccc")
                .authorities("SALES","ADMIN")
                .build();
        return new InMemoryUserDetailsManager(admin, guest, all);
    }
}
