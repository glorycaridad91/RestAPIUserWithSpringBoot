package com.ejercicioglo.app.controller;

import com.ejercicioglo.app.entity.User;
import com.ejercicioglo.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;



@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Create a new user
    @PostMapping
    public ResponseEntity<?> create (@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));

    }

    //Read an user
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value = "id") Long id){
        Optional<User> optionalUser = userService.findById(id);

        if (optionalUser.isPresent()) {
            return ResponseEntity.ok(optionalUser);
        }
        return ResponseEntity.notFound().build();
    }

    //Update an user
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody User userDetails, @PathVariable(value = "id") Long userId){
        Optional<User> user = userService.findById(userId);

        if(!user.isPresent()){
            return ResponseEntity.notFound().build();
        }

        user.get().setName(userDetails.getName());
        user.get().setSurname(userDetails.getSurname());
        user.get().setEmail(userDetails.getEmail());
        user.get().setEnabled(userDetails.isEnabled());

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user.get()));
    }

    //Delete an user
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long userId){

        if (!userService.findById(userId).isPresent()){
            return ResponseEntity.notFound().build();
        }
        userService.deleteById(userId);
        return ResponseEntity.ok().build();
    }

    //Read all Users
    @GetMapping
    public List<User> readAll(){
        return (List<User>) StreamSupport
                .stream(userService.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}










