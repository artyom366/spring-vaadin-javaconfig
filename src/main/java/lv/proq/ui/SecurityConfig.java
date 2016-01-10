package lv.proq.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Artyom on 1/10/2016.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{

        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager();
        userDetailsManager.setDataSource(dataSource);

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        auth.userDetailsService(userDetailsManager).passwordEncoder(bCryptPasswordEncoder);
        auth.jdbcAuthentication().dataSource(dataSource);

        if (!userDetailsManager.userExists("user")) {
            List<GrantedAuthority> authorityList = new ArrayList<GrantedAuthority>();
            authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));

            User user = new User("user", bCryptPasswordEncoder.encode("pass"), authorityList);
            userDetailsManager.createUser(user);
        }
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests()
                .antMatchers("/", "/test", "/log1n", "/log1n/*", "/VAADIN/**", "/PUSH/**", "/UIDL/**", "/api/test").permitAll()
                .antMatchers("/user/**").access("hasRole('ROLE_USER')")
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout()
                .permitAll()
                .and()
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/log1n"))
                .and()
                .logout().logoutSuccessUrl("/log1n");
    }
}
