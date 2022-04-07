package com.maxeluds.hruser.resource;

import com.maxeluds.hruser.entities.User;
import com.maxeluds.hruser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    @Autowired
    private UserRepository repository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return ResponseEntity.ok(repository.findById(id).get());
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        return ResponseEntity.ok(repository.findByEmail(email));
    }

}
