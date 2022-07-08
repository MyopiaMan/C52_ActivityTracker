package by.paliakou.c52_activitytracker.controller;

import by.paliakou.c52_activitytracker.entity.User;
import by.paliakou.c52_activitytracker.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Saving new user")
    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        User newUser = userService.save(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @Operation(summary = "Find user by username")
    @GetMapping("/{username}")
    public ResponseEntity<User> findUserByUsername(@PathVariable String username) {
        Optional<User> byUsername = userService.findUserByUsername(username);
        if (byUsername.isPresent()) {
            return ResponseEntity.ok(byUsername.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @Operation(summary = "Update user")
    @PutMapping("/userUpdate/{id}")
    public ResponseEntity<User> userUpdate(@RequestBody User user, @PathVariable Long id){
        Optional<User> update = userService.findById(id);
        if (update.isPresent()){
            user.setUsername(update.get().getUsername());
            user.setFirstName(update.get().getFirstName());
            user.setLastName(update.get().getLastName());
            user.setEmail(update.get().getEmail());
            User updateUser = userService.save(user);
            return ResponseEntity.ok(updateUser);
        }
        return ResponseEntity.badRequest().build();
    }
}
