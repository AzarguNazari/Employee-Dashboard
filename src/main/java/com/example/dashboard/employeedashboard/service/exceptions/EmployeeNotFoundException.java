package com.example.dashboard.employeedashboard.service.exceptions;

public class EmployeeNotFoundException extends RuntimeException {

    private long customerId;

    public EmployeeNotFoundException(long cid) {
        super("employee#" + cid + " was not found");
        this.customerId = cid;
    }

    public long getCustomerId() {
        return customerId;
    }
}

