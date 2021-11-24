package com.dashboard.backend.repositories;

import com.dashboard.backend.models.jpa.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
