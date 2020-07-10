package com.fastEmployee.dashboard.employeedashboard.repository;

import com.fastEmployee.dashboard.employeedashboard.model.employee.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
