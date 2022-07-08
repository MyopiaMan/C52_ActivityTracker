package by.paliakou.c52_activitytracker.controller;

import by.paliakou.c52_activitytracker.entity.ActivityEvent;
import by.paliakou.c52_activitytracker.entity.TypeOfActivity;
import by.paliakou.c52_activitytracker.entity.User;
import by.paliakou.c52_activitytracker.entity.parameters.UserHealthParameter;
import by.paliakou.c52_activitytracker.repository.ActivityEventRepository;
import by.paliakou.c52_activitytracker.service.ActivityEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/activity")
public class ActivityEventController {

    @Autowired
    ActivityEventService activityEventService;

    @Autowired
    ActivityEventRepository activityEventRepository;

    public ResponseEntity<ActivityEvent> badRequest() {
        return ResponseEntity.badRequest().build();
    }

    @PostMapping
    public ResponseEntity<ActivityEvent> saveActivityEvent(@RequestBody ActivityEvent activityEvent){
        ActivityEvent newActivityEvent = activityEventService.save(activityEvent);
        return new ResponseEntity<>(newActivityEvent, HttpStatus.CREATED);
    }

    @GetMapping
    public List<ActivityEvent> findAll(){
        return activityEventRepository.findAll();
    }//?????

    @GetMapping("/{user}")
    public ResponseEntity<ActivityEvent> findActivityEventsByUser (@PathVariable User user){
        Optional<ActivityEvent> activityEventByUser = activityEventService.findActivityEventByUser(user);
        if (activityEventByUser.isPresent()){
            return ResponseEntity.ok(activityEventByUser.get());
        }
        return badRequest();
    }

    @GetMapping("/{type}")
    public ResponseEntity<ActivityEvent> findActivityEventsByTypeOfActivity
            (@PathVariable TypeOfActivity type){
        Optional<ActivityEvent> activityEventByType = activityEventService.findActivityEventByType(type);
        if (activityEventByType.isPresent()){
            return ResponseEntity.ok(activityEventByType.get());
        }
        return badRequest();
    }

    @GetMapping("/{distance}")
    public ResponseEntity<ActivityEvent> findActivityEventsByDistance(@PathVariable int distance){
        Optional<ActivityEvent> activityEventByDistance =
                activityEventService.findActivityEventByDistance(distance);
        if (activityEventByDistance.isPresent()){
            return ResponseEntity.ok(activityEventByDistance.get());
        }
        return badRequest();
    }

    @GetMapping("/{speed}")
    public ResponseEntity<ActivityEvent> findActivityEventsBySpeed(@PathVariable int speed){
        Optional<ActivityEvent> activityEventBySpeed = activityEventService.findActivityEventBySpeed(speed);
        if (activityEventBySpeed.isPresent()){
            return ResponseEntity.ok(activityEventBySpeed.get());
        }
        return badRequest();
    }

    @GetMapping("/{activityPulse}")
    public ResponseEntity<ActivityEvent> findActivityEventsByPulse(@PathVariable int activityPulse){
        Optional<ActivityEvent> activityEventByPulse = activityEventService.findActivityEventByActivityPulse(activityPulse);
        if (activityEventByPulse.isPresent()){
            return ResponseEntity.ok(activityEventByPulse.get());
        }
        return badRequest();
    }

    @GetMapping("/{activityEnergy}")
    public ResponseEntity<ActivityEvent> findActivityEventsByEnergy(@PathVariable BigDecimal activityEnergy){
        Optional<ActivityEvent> activityEventByEnergy = activityEventService.findActivityEventByEnergy(activityEnergy);
        if (activityEventByEnergy.isPresent()){
            return ResponseEntity.ok(activityEventByEnergy.get());
        }
        return badRequest();
    }

    @PutMapping("/purposeUpdate/{id}")
    public ResponseEntity<ActivityEvent> purposeUpdate
            (@RequestBody ActivityEvent activityEvent, @PathVariable Long id){
        Optional<ActivityEvent> activityEventById = activityEventService.findActivityEventById(id);
        if (activityEventById.isPresent()){
            activityEvent.setPurpose(activityEventById.get().getPurpose());
            ActivityEvent purposeUpdate = activityEventService.save(activityEvent);
            return ResponseEntity.ok(purposeUpdate);
        }
        return badRequest();
    }

    @PutMapping("/activityParamsUpdate/{id}")
    public ResponseEntity<ActivityEvent> activityParamsUpdate
            (@RequestBody ActivityEvent activityEvent, @PathVariable Long id){
        Optional<ActivityEvent> activityEventById = activityEventService.findActivityEventById(id);
        if (activityEventById.isPresent()){
            activityEvent.setActivityEnergy(activityEventById.get().getActivityEnergy());
            activityEvent.setActivityPulse(activityEventById.get().getActivityPulse());
            activityEvent.setDistance(activityEventById.get().getDistance());
            activityEvent.setSpeed(activityEventById.get().getSpeed());
            activityEvent.setElevationGain(activityEventById.get().getElevationGain());
            ActivityEvent activityParamsUpdate = activityEventService.save(activityEvent);
            return ResponseEntity.ok(activityParamsUpdate);
        }
        return badRequest();
    }

    @PutMapping("/repetitionsUpdate/{id}")
    public ResponseEntity<ActivityEvent> repetitionsUpdate
            (@RequestBody ActivityEvent activityEvent, @PathVariable Long id){
        Optional<ActivityEvent> activityEventById = activityEventService.findActivityEventById(id);
        if (activityEventById.isPresent()){
            activityEvent.setRepetitions(activityEventById.get().getRepetitions());
            activityEvent.setRepetitionStartTime(activityEventById.get().getRepetitionStartTime());
            activityEvent.setRepetitionEnergy(activityEventById.get().getRepetitionEnergy());
            ActivityEvent repetitionsUpdate = activityEventService.save(activityEvent);
            return ResponseEntity.ok(repetitionsUpdate);
        }
        return badRequest();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteActivityEvent(@PathVariable Long id){
        activityEventService.deleteActivityEvent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
