package com.dashboard.repository;

import com.dashboard.model.Attendance;
import com.dashboard.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {

}
