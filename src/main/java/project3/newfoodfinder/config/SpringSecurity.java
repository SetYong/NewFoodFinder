package project3.newfoodfinder.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@EnableMethodSecurity
@Configuration
@RequiredArgsConstructor
public class SpringSecurity {

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return (web) -> web.ignoring().requestMatchers("/예외처리하고싶은 url", "/예외처리하고싶은 url");
    }

    @Bean
    protected SecurityFilterChain webSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers("/로그인페이지","/css/**","/images/**","/js/**").permitAll()
                .anyRequest().authenticated()

                .and()
                .formLogin()
                .loginPage("/로그인페이지")
                .loginProcessingUrl("/실제 로그인이 되는 url")
                .permitAll()
                .successHandler(로그인 성공 시 실행할 커스터마이즈드 핸들러)
                .failureHandler(로그인 실패 시 실행할 커스터마이즈드 핸들러);
        http
                .sessionManagement()
                .invalidSessionUrl("/로그인페이지")

                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/실제 로그아웃이 되는 url"))
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll();

        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
        return http.build();
    }

}
