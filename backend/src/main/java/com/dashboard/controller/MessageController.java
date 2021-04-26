package com.dashboard.controller;

import com.dashboard.interfaces.controllerInterfaces.MessageControllerInterface;
import com.dashboard.model.Message;
import com.dashboard.service.ChatService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/api/v1/messages")
public class MessageController implements MessageControllerInterface {

    @Autowired
    private ChatService chatService;

    @Override
    public ResponseEntity<?> createMessage(Message message) {
        return null;
    }

    @Override
    public ResponseEntity<?> getAllMessages() {
        return null;
    }

    @Override
    public ResponseEntity<?> getMessageById(Integer messageID) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteMessageById(Integer messageID) {
        return null;
    }

    @Override
    public ResponseEntity<?> updateMessage(Integer messageID, Message Message) {
        return null;
    }
}
