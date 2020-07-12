package com.example.dashboard.employeedashboard.repository;

import com.example.dashboard.employeedashboard.model.employee.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
