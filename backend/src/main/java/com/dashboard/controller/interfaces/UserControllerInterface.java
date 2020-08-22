package com.dashboard.controller.interfaces;

import com.dashboard.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface UserControllerInterface {

    @PostMapping
    ResponseEntity<?> createUser(@RequestBody User user);

    @GetMapping
    ResponseEntity<?> getAllUsers();

    @GetMapping("/{userID}")
    ResponseEntity<?> getUserById(@PathVariable Integer userID);

    @DeleteMapping("/{userID}")
    ResponseEntity<?> deleteUserById(@PathVariable Integer userID);

    @PutMapping("/{userID}")
    ResponseEntity<?> updateUser(@PathVariable Integer userID, @RequestBody User user);
}
