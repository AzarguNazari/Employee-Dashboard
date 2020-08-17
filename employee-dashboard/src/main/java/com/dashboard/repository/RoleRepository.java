package com.dashboard.repository;

import com.dashboard.model.employee.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
