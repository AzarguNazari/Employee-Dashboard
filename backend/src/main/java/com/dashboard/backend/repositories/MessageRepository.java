package com.dashboard.backend.repositories;

import com.dashboard.backend.models.jpa.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {

}
