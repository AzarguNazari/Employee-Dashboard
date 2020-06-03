package com.example.dashboard.employeedashboard.security;

import com.example.dashboard.employeedashboard.repository.EmployeeRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationSuccessorHandlerImpl implements AuthenticationSuccessHandler {

    private static final Log LOGGER = LogFactory.getLog(AuthenticationSuccessorHandlerImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication authentication) throws IOException, ServletException {
//        employeeRepository.updateLastLogin(new Date());
        // we can update the last login date

        LOGGER.debug("Here is the debug");
    }

}