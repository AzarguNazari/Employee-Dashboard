//package com.example.dashboard.employeedashboard.security;
//
//import com.example.dashboard.employeedashboard.model.Employee;
//import com.example.dashboard.employeedashboard.repository.EmployeeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.WebApplicationContext;
//
//import javax.annotation.PostConstruct;
//import java.util.Optional;
//
//@Component
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private WebApplicationContext applicationContext;
//    private EmployeeRepository employeeRepository;
//
//    public CustomUserDetailsService() {
//        super();
//    }
//
//    @PostConstruct
//    public void completeSetup() {
//        employeeRepository = applicationContext.getBean(EmployeeRepository.class);
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(final String username) {
//        Optional<Employee> employee = employeeRepository.findByUsername(username);
//        if (!employee.isPresent()) {
//            throw new UsernameNotFoundException(username);
//        }
//        return new AppUserPrincipal(employee.get());
//    }
//}