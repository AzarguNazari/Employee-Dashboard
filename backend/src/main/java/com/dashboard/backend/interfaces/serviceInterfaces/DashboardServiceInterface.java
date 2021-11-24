package com.dashboard.backend.interfaces.serviceInterfaces;

import com.dashboard.backend.models.JPA.EmployeeDto;

public interface DashboardServiceInterface {
    void createAccount(EmployeeDto employeeDto);
}
