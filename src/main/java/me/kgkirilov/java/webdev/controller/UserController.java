package me.kgkirilov.java.webdev.controller;

import me.kgkirilov.java.webdev.dao.UserDaoService;
import me.kgkirilov.java.webdev.data.User;
import me.kgkirilov.java.webdev.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDaoService service;

    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    @GetMapping(path = "users/{id}")
    public User retrieveUser(@PathVariable Integer id) {
        User user = service.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("id="+id);
        }

        return service.findOne(id);
    }

    @DeleteMapping(path = "users/{id}")
    public User deleteUser(@PathVariable Integer id) {
        User user = service.deleteById(id);
        if (user == null) {
            throw new UserNotFoundException("id="+id);
        }

        return service.findOne(id);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

       return ResponseEntity.created(location).build();
    }
}
