//package com.example.dashboard.employeedashboard;
//
//import com.example.dashboard.employeedashboard.security.AuthenticationSuccessorHandlerImpl;
//import com.example.dashboard.employeedashboard.security.CustomUserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;
//import org.springframework.web.context.WebApplicationContext;
//
//import javax.annotation.PostConstruct;
//import javax.sql.DataSource;
//
//@Configuration
//@EnableWebSecurity
//@ComponentScan("com.example.dashboard.employeedashboard.security")
//public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private WebApplicationContext applicationContext;
//    private CustomUserDetailsService userDetailsService;
//    @Autowired
//    private AuthenticationSuccessorHandlerImpl successHandler;
//    @Autowired
//    private DataSource dataSource;
//
//    @PostConstruct
//    public void completeSetup() {
//        userDetailsService = applicationContext.getBean(CustomUserDetailsService.class);
//    }
//
//    @Override
//    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user1").password(encoder().encode("user1Pass")).roles("USER")
//                .and()
//                .withUser("user2").password(encoder().encode("user2Pass")).roles("USER")
//                .and()
//                .withUser("admin").password(encoder().encode("adminPass")).roles("ADMIN");
//    }
//
////    @Override
////    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
////        auth.userDetailsService(userDetailsService)
////            .passwordEncoder(encoder())
////            .and()
////            .authenticationProvider(authenticationProvider())
////            .jdbcAuthentication()
////            .dataSource(dataSource);
////    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/resources/**");
//    }
//
//    @Override
//    protected void configure(final HttpSecurity http) throws Exception {
//        http.headers().frameOptions().disable();
//        http.authorizeRequests()
//            .antMatchers("/dashboard/login", "/h2-console/**", "/dashboard/dist/**", "/dashboard/vendor/**")
//            .permitAll()
//            .anyRequest()
//            .authenticated()
//            .and()
//            .formLogin()
//            .loginPage("/dashboard/login")
//            .permitAll()
//            .successHandler(successHandler)
//            .and()
//            .csrf()
//            .disable();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService);
//        authProvider.setPasswordEncoder(encoder());
//        return authProvider;
//    }
//
//    @Bean
//    public PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder(11);
//    }
//
//    @Bean
//    public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
//        return new SecurityEvaluationContextExtension();
//    }
//}