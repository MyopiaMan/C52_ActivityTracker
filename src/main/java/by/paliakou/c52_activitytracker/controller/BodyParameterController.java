package by.paliakou.c52_activitytracker.controller;

import by.paliakou.c52_activitytracker.entity.User;
import by.paliakou.c52_activitytracker.entity.UserGender;
import by.paliakou.c52_activitytracker.entity.parameters.UserBodyParameter;
import by.paliakou.c52_activitytracker.service.UserBodyParameterService;
import by.paliakou.c52_activitytracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userBodyParameters")
public class BodyParameterController {

    @Autowired
    UserBodyParameterService userBodyParameterService;

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<UserBodyParameter> saveBodyParameters
            (@RequestBody UserBodyParameter userBodyParameter){
        UserBodyParameter newParam = userBodyParameterService.save(userBodyParameter);
        return new ResponseEntity<>(newParam, HttpStatus.CREATED);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserBodyParameter> findBodyParametersByUser(@PathVariable String username){

    }

    @GetMapping("/{userGender}")
    public ResponseEntity<UserBodyParameter> findBodyParametersByUserGender
            (@PathVariable UserGender userGender){
        Optional<UserBodyParameter> paramsByGender =
                userBodyParameterService.findUserBodyParametersByGender(userGender);
        if (paramsByGender.isPresent()){
            return ResponseEntity.ok(paramsByGender.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{userAge}")
    public ResponseEntity<UserBodyParameter> findBodyParametersByUserAge(@PathVariable int userAge){
        Optional<UserBodyParameter> paramsByAge =
                userBodyParameterService.findUserBodyParametersByAge(userAge);
        if (paramsByAge.isPresent()){
            return ResponseEntity.ok(paramsByAge.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{userWeight}")
    public ResponseEntity<UserBodyParameter> findBodyParametersByUserWeight(@PathVariable BigDecimal userWeight){
        Optional<UserBodyParameter> paramsByWeight =
                userBodyParameterService.findUserBodyParametersByWeight(userWeight);
        if (paramsByWeight.isPresent()){
            return ResponseEntity.ok(paramsByWeight.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{userHeight}")
    public ResponseEntity<UserBodyParameter> findBodyParametersByUserHeight(@PathVariable BigDecimal userHeight){
        Optional<UserBodyParameter> paramsByHeight =
                userBodyParameterService.findUserBodyParametersByHeight(userHeight);
        if (paramsByHeight.isPresent()){
            return ResponseEntity.ok(paramsByHeight.get());
        }
        return ResponseEntity.badRequest().build();
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
