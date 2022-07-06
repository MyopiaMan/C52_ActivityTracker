package by.paliakou.c52_activitytracker.controller;

import by.paliakou.c52_activitytracker.entity.User;
import by.paliakou.c52_activitytracker.entity.parameters.UserBodyParameter;
import by.paliakou.c52_activitytracker.service.UserBodyParameterService;
import by.paliakou.c52_activitytracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userBodyParameter")
public class BodyParameterController {

    @Autowired
    UserBodyParameterService userBodyParameterService;

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<UserBodyParameter> saveBodyParameter
            (@RequestBody UserBodyParameter userBodyParameter){
        UserBodyParameter newParam = userBodyParameterService.save(userBodyParameter);
        return new ResponseEntity<>(newParam, HttpStatus.CREATED);
    }

//    @GetMapping("/{username}")
//    public List<UserBodyParameter> findAllBodyParametersByUser(@RequestBody User user){
//        Optional<User> userParameters = userService.findUserByUsername(user.getUsername());
//        if (userParameters.isPresent()){
//            return userBodyParameterService.findAllUserBodyParametersByUser(user);
//        }
//        return ;
//    }
}
