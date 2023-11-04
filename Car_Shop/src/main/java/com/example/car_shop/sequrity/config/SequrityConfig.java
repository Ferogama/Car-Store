package com.example.car_shop.sequrity.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SequrityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    //Два класса используют интерфейс, поэтому используем анотацию
    @Qualifier("customUserDetailService")
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/signUp").permitAll()
                //у кого есть доступ к странице users
                .antMatchers("/users").hasAuthority("ADMIN")
                .antMatchers("users/del/**").hasAuthority("ADMIN")
                .antMatchers("/addCar").hasAuthority("ADMIN")
                .antMatchers("/cars/delete/**").hasAuthority("ADMIN")
                .antMatchers("/cars/update/**").hasAuthority("ADMIN")
                .antMatchers("/cars/**").authenticated()
                .antMatchers("/logout").authenticated()
                .antMatchers("/profile").authenticated()
                .and()
                .formLogin()
                .loginPage("/signIn")
                .usernameParameter("email")
                .defaultSuccessUrl("/cars")
                .failureUrl("/signIn?error")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                //сбрасываем все сессии которые были
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
