package by.paliakou.c52_activitytracker.controller;

import by.paliakou.c52_activitytracker.entity.SleepEvent;
import by.paliakou.c52_activitytracker.entity.StageOfSleep;
import by.paliakou.c52_activitytracker.repository.SleepEventRepository;
import by.paliakou.c52_activitytracker.service.SleepEventService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sleeping")
public class SleepEventController {

    @Autowired
    SleepEventService sleepEventService;

    public ResponseEntity<SleepEvent> badRequest() {
        return ResponseEntity.badRequest().build();
    }

    @Autowired
    SleepEventRepository sleepEventRepository;

    @Operation(summary = "Save user's sleep parameters")
    @PostMapping
    public ResponseEntity<SleepEvent> saveSleepParameters(@RequestBody SleepEvent sleepEvent){
        SleepEvent newSleepEvent = sleepEventService.save(sleepEvent);
        return new ResponseEntity<>(newSleepEvent, HttpStatus.CREATED);
    }

    @Operation(summary = "Find all user's sleep parameters")
    @GetMapping
    public List<SleepEvent> findAll(){
        return sleepEventRepository.findAll();
    }//?????

    @Operation(summary = "Find user's sleep parameters by stage of sleep")
    @GetMapping("/{stage}")
    public ResponseEntity<SleepEvent> findSleepEventsByStage(@PathVariable StageOfSleep stage){
        Optional<SleepEvent> sleepEventsByStage = sleepEventService.findSleepEventsByStage(stage);
        if (sleepEventsByStage.isPresent()){
            return ResponseEntity.ok(sleepEventsByStage.get());
        }
        return badRequest();
    }

    @Operation(summary = "Find user's sleep parameters by rating of sleep")
    @GetMapping("/{rating}")
    public ResponseEntity<SleepEvent> findSleepEventsByRating(@PathVariable int rating){
        Optional<SleepEvent> sleepEventsByRating = sleepEventService.findSleepEventsByRating(rating);
        if (sleepEventsByRating.isPresent()){
            return ResponseEntity.ok(sleepEventsByRating.get());
        }
        return badRequest();
    }

    @Operation(summary = "Update all user's sleep parameters")
    @PutMapping("/eventUpdate/{id}")
    public ResponseEntity<SleepEvent> eventUpdate
            (@RequestBody SleepEvent sleepEvent, @PathVariable Long id){
        Optional<SleepEvent> sleepEventById = sleepEventService.findSleepEventById(id);
        if (sleepEventById.isPresent()){
            sleepEvent.setSleepStartTime(sleepEventById.get().getSleepStartTime());
            sleepEvent.setSleepFinishTime(sleepEventById.get().getSleepFinishTime());
            sleepEvent.setStage(sleepEventById.get().getStage());
            sleepEvent.setStageStartTime(sleepEventById.get().getStageStartTime());
            sleepEvent.setRating(sleepEventById.get().getRating());
            SleepEvent sleepEventUpdate = sleepEventService.save(sleepEvent);
            return ResponseEntity.ok(sleepEventUpdate);
        }
        return badRequest();
    }

    @Operation(summary = "Update stage of sleep")
    @PutMapping("/stageUpdate/{id}")
    public ResponseEntity<SleepEvent> stageUpdate
            (@RequestBody SleepEvent sleepEvent, @PathVariable Long id){
        Optional<SleepEvent> sleepEventById = sleepEventService.findSleepEventById(id);
        if (sleepEventById.isPresent()){
            sleepEvent.setStage(sleepEventById.get().getStage());
            sleepEvent.setStageStartTime(sleepEventById.get().getStageStartTime());
            SleepEvent sleepStageUpdate = sleepEventService.save(sleepEvent);
            return ResponseEntity.ok(sleepStageUpdate);
        }
        return badRequest();
    }

    @Operation(summary = "Delete all user's sleep parameters")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSleepEvent(@PathVariable Long id){
        sleepEventService.deleteSleepEvent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
