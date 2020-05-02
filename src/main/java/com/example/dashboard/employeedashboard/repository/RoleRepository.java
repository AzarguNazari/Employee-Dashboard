package com.example.dashboard.employeedashboard.repository;

import com.example.dashboard.employeedashboard.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
