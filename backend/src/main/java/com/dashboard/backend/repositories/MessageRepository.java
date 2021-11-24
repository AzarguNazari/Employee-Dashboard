package com.dashboard.backend.repositories;

import com.dashboard.backend.models.JPA.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {

}
