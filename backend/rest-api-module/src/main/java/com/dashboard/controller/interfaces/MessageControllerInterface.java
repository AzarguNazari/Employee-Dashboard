package com.dashboard.controller.interfaces;

import com.dashboard.model.Message;
import com.dashboard.model.Message;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface MessageControllerInterface {

    @PostMapping
    ResponseEntity<?> createMessage(@RequestBody Message message);

    @GetMapping
    ResponseEntity<?> getAllMessages();

    @GetMapping("/{messageID}")
    ResponseEntity<?> getMessageById(@PathVariable Integer messageID);

    @DeleteMapping("/{messageID}")
    ResponseEntity<?> deleteMessageById(@PathVariable Integer messageID);

    @PutMapping("/{messageID}")
    ResponseEntity<?> updateMessage(@PathVariable Integer messageID, @RequestBody Message Message);
}
