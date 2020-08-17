package com.dashboard.service.exceptions;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message){
        super(message);
    }
    public EmployeeNotFoundException(long cid) {
        super("employee#" + cid + " was not found");
    }
}

