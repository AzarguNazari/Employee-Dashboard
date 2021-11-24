package com.dashboard.backend.interfaces.serviceInterfaces;

import com.dashboard.backend.models.jpa.EmployeeDto;

public interface DashboardServiceInterface {
    void createAccount(EmployeeDto employeeDto);
}
