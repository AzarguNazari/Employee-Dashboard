//package com.example.dashboard.employeedashboard;
//
//import com.example.dashboard.employeedashboard.security.AuthenticationSuccessorHandlerImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@Configuration
//@EnableWebSecurity
//@ComponentScan("com.example.dashboard.employeedashboard.security")
//public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private AuthenticationSuccessorHandlerImpl successHandler;
//
////    @Override
////    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
////        auth.inMemoryAuthentication()
////                .withUser("user1").password(encoder().encode("pass1")).roles("USER")
////                .and()
////                .withUser("user2").password(encoder().encode("pass1")).roles("USER")
////                .and()
////                .withUser("admin").password(encoder().encode("admin")).roles("ADMIN");
////    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/resources/**");
//    }
//
//    @Override
//    protected void configure(final HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http.headers().frameOptions().disable(); // for h2-console frame
//        http.authorizeRequests()
//            .antMatchers("/", "/h2-console/**", "/dashboard/dist/**", "/dashboard/vendor/**")
//            .permitAll()
//            .anyRequest().authenticated()
////            .hasAnyRole("ADMIN", "USER")
//            .and()
//            .formLogin()
//            .loginPage("/dashboard/login")
//            .permitAll()
//            .successHandler(successHandler)
//            .and()
//            .logout()
//            .permitAll();
//    }
//
////    @Bean
////    @Override
////    public UserDetailsService userDetailsService(){
////        UserDetails user = User.withDefaultPasswordEncoder()
////                                .username("user")
////                                .password("password")
////                                .roles("USER").build();
////        return new InMemoryUserDetailsManager(user);
////    }
//
//    @Bean
//    public PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder(11);
//    }
//}