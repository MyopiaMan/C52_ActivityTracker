package by.paliakou.c52_activitytracker.controller;

import by.paliakou.c52_activitytracker.entity.User;
import by.paliakou.c52_activitytracker.entity.parameters.UserHealthParameter;
import by.paliakou.c52_activitytracker.service.UserHealthParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/healthParameters")
public class UserHealthParameterController {

    @Autowired
    UserHealthParameterService usHealthParamService;

    @PostMapping
    public ResponseEntity<UserHealthParameter> saveHealthParameters
            (@RequestBody UserHealthParameter usHealthParam){
        UserHealthParameter newParam = usHealthParamService.save(usHealthParam);
        return new ResponseEntity<>(newParam, HttpStatus.CREATED);
    }

    @GetMapping("/{user}")
    public ResponseEntity<UserHealthParameter> findHealthParamsByUser (@PathVariable User user){
        Optional<UserHealthParameter> healthParamsByUser =
                usHealthParamService.findHealthParamsByUser(user);
        if (healthParamsByUser.isPresent()){
            return ResponseEntity.ok(healthParamsByUser.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{oxygenSaturation}")
    public ResponseEntity<UserHealthParameter> findHealthParamsByOxygenSaturation (@PathVariable int oxygenSaturation){
        Optional<UserHealthParameter> paramsByOxygenSaturation =
                usHealthParamService.findHealthParamsByOxygenSaturation(oxygenSaturation);
        if (paramsByOxygenSaturation.isPresent()){
            return ResponseEntity.ok(paramsByOxygenSaturation.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{bodyTemperature}")
    public ResponseEntity<UserHealthParameter> findHealthParamsByBodyTemperature
            (@PathVariable BigDecimal bodyTemperature){
        Optional<UserHealthParameter> paramsByBodyTemperature =
                usHealthParamService.findHealthParamsByBodyTemperature(bodyTemperature);
        if (paramsByBodyTemperature.isPresent()){
            return ResponseEntity.ok(paramsByBodyTemperature.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{pulse}")
    public ResponseEntity<UserHealthParameter> findHealthParamsByBodyPulse(@PathVariable int pulse){
        Optional<UserHealthParameter> paramsByPulse = usHealthParamService.findHealthParamsByPulse(pulse);
        if (paramsByPulse.isPresent()){
            return ResponseEntity.ok(paramsByPulse.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/oxygenUpdate/{id}")
    public ResponseEntity<UserHealthParameter> oxygenUpdate
            (@RequestBody UserHealthParameter userHealthParameter, @PathVariable Long id){
        Optional<UserHealthParameter> userParamById = usHealthParamService.findHealthParametersById(id);
        if (userParamById.isPresent()){
            userHealthParameter.setOxygenSaturation(userParamById.get().getOxygenSaturation());
            UserHealthParameter userOxygenUpdate = usHealthParamService.save(userHealthParameter);
            return ResponseEntity.ok(userOxygenUpdate);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/temperatureUpdate/{id}")
    public ResponseEntity<UserHealthParameter> temperatureUpdate
            (@RequestBody UserHealthParameter userHealthParameter, @PathVariable Long id){
        Optional<UserHealthParameter> userParamById = usHealthParamService.findHealthParametersById(id);
        if (userParamById.isPresent()){
            userHealthParameter.setBodyTemperature(userParamById.get().getBodyTemperature());
            UserHealthParameter userTemperatureUpdate = usHealthParamService.save(userHealthParameter);
            return ResponseEntity.ok(userTemperatureUpdate);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/pulseUpdate/{id}")
    public ResponseEntity<UserHealthParameter> pulseUpdate
            (@RequestBody UserHealthParameter userHealthParameter, @PathVariable Long id){
        Optional<UserHealthParameter> userParamById = usHealthParamService.findHealthParametersById(id);
        if (userParamById.isPresent()){
            userHealthParameter.setPulse(userParamById.get().getPulse());
            userHealthParameter.setHeartRate(userParamById.get().getHeartRate());
            userHealthParameter.setRestingHeartRate(userParamById.get().getRestingHeartRate());
            UserHealthParameter userPulseUpdate = usHealthParamService.save(userHealthParameter);
            return ResponseEntity.ok(userPulseUpdate);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteHealthParameters(@PathVariable Long id){
        usHealthParamService.deleteUserHealthParameter(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
