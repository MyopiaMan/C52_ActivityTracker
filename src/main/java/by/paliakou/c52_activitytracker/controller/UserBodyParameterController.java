package by.paliakou.c52_activitytracker.controller;

import by.paliakou.c52_activitytracker.entity.UserGender;
import by.paliakou.c52_activitytracker.entity.parameters.UserBodyParameter;
import by.paliakou.c52_activitytracker.service.UserBodyParameterService;
import by.paliakou.c52_activitytracker.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/bodyParameters")
public class UserBodyParameterController {

    @Autowired
    UserBodyParameterService usBodyParamService;

    @Autowired
    UserService userService;

    public ResponseEntity<UserBodyParameter> badRequest() {
        return ResponseEntity.badRequest().build();
    }

    @Operation(summary = "Saving user's body parameters")
    @PostMapping
    public ResponseEntity<UserBodyParameter> saveBodyParameters
            (@RequestBody UserBodyParameter userBodyParameter){
        UserBodyParameter newParam = usBodyParamService.save(userBodyParameter);
        return new ResponseEntity<>(newParam, HttpStatus.CREATED);
    }

    @Operation(summary = "Find body parameters by user's gender")
    @GetMapping("/{gender}")
    public ResponseEntity<UserBodyParameter> findByGender
            (@PathVariable UserGender gender){
        Optional<UserBodyParameter> paramsByGender =
                usBodyParamService.findUserBodyParametersByGender(gender);
        if (paramsByGender.isPresent()){
            return ResponseEntity.ok(paramsByGender.get());
        }
        return badRequest();
    }

    @Operation(summary = "Find body parameters by user's age")
    @GetMapping("/{age}")
    public ResponseEntity<UserBodyParameter> findByAge(@PathVariable int age){
        Optional<UserBodyParameter> paramsByAge =
                usBodyParamService.findUserBodyParametersByAge(age);
        if (paramsByAge.isPresent()){
            return ResponseEntity.ok(paramsByAge.get());
        }
        return badRequest();
    }

    @Operation(summary = "Find body parameters by user's weight")
    @GetMapping("/{weight}")
    public ResponseEntity<UserBodyParameter> findByWeight(@PathVariable BigDecimal weight){
        Optional<UserBodyParameter> paramsByWeight =
                usBodyParamService.findUserBodyParametersByWeight(weight);
        if (paramsByWeight.isPresent()){
            return ResponseEntity.ok(paramsByWeight.get());
        }
        return badRequest();
    }

    @Operation(summary = "Find body parameters by user's height")
    @GetMapping("/{height}")
    public ResponseEntity<UserBodyParameter> findByHeight(@PathVariable BigDecimal height){
        Optional<UserBodyParameter> paramsByHeight =
                usBodyParamService.findUserBodyParametersByHeight(height);
        if (paramsByHeight.isPresent()){
            return ResponseEntity.ok(paramsByHeight.get());
        }
        return badRequest();
    }

    @Operation(summary = "User's age update")
    @PutMapping("/ageUpdate/{id}")
    public ResponseEntity<UserBodyParameter> ageUpdate
            (@RequestBody UserBodyParameter userBodyParameter, @PathVariable Long id){
        Optional<UserBodyParameter> userParamById = usBodyParamService.findBodyParametersById(id);
        if (userParamById.isPresent()){
            userBodyParameter.setAge(userParamById.get().getAge());
            UserBodyParameter userAgeUpdate = usBodyParamService.save(userBodyParameter);
            return ResponseEntity.ok(userAgeUpdate);
        }
        return badRequest();
    }

    @Operation(summary = "User's height update")
    @PutMapping("/heightUpdate/{id}")
    public ResponseEntity<UserBodyParameter> heightUpdate
            (@RequestBody UserBodyParameter userBodyParameter, @PathVariable Long id){
        Optional<UserBodyParameter> userParamById = usBodyParamService.findBodyParametersById(id);
        if (userParamById.isPresent()){
            userBodyParameter.setHeight(userParamById.get().getHeight());
            UserBodyParameter userHeightUpdate = usBodyParamService.save(userBodyParameter);
            return ResponseEntity.ok(userHeightUpdate);
        }
        return badRequest();
    }

    @Operation(summary = "User's weight update")
    @PutMapping("/weightUpdate/{id}")
    public ResponseEntity<UserBodyParameter> weightUpdate
            (@RequestBody UserBodyParameter userBodyParameter, @PathVariable Long id){
        Optional<UserBodyParameter> userParamById = usBodyParamService.findBodyParametersById(id);
        if (userParamById.isPresent()){
            userBodyParameter.setWeight(userParamById.get().getWeight());
            UserBodyParameter userWeightUpdate = usBodyParamService.save(userBodyParameter);
            return ResponseEntity.ok(userWeightUpdate);
        }
        return badRequest();
    }

    @Operation(summary = "Deleting all parameters of the user's body")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBodyParameters(@PathVariable Long id){
        usBodyParamService.deleteUserBodyParameter(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
