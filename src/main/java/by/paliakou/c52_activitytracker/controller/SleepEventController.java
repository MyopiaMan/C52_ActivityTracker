package by.paliakou.c52_activitytracker.controller;

import by.paliakou.c52_activitytracker.entity.SleepEvent;
import by.paliakou.c52_activitytracker.entity.StageOfSleep;
import by.paliakou.c52_activitytracker.repository.SleepEventRepository;
import by.paliakou.c52_activitytracker.service.SleepEventService;
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

    @PostMapping
    public ResponseEntity<SleepEvent> saveSleepParameters(@RequestBody SleepEvent sleepEvent){
        SleepEvent newSleepEvent = sleepEventService.save(sleepEvent);
        return new ResponseEntity<>(newSleepEvent, HttpStatus.CREATED);
    }

    @GetMapping
    public List<SleepEvent> findAll(){
        return sleepEventRepository.findAll();
    }//?????

    @GetMapping("/{stage}")
    public ResponseEntity<SleepEvent> findSleepEventsByStage(@PathVariable StageOfSleep stage){
        Optional<SleepEvent> sleepEventsByStage = sleepEventService.findSleepEventsByStage(stage);
        if (sleepEventsByStage.isPresent()){
            return ResponseEntity.ok(sleepEventsByStage.get());
        }
        return badRequest();
    }

    @GetMapping("/{rating}")
    public ResponseEntity<SleepEvent> findSleepEventsByRating(@PathVariable int rating){
        Optional<SleepEvent> sleepEventsByRating = sleepEventService.findSleepEventsByRating(rating);
        if (sleepEventsByRating.isPresent()){
            return ResponseEntity.ok(sleepEventsByRating.get());
        }
        return badRequest();
    }

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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSleepEvent(@PathVariable Long id){
        sleepEventService.deleteSleepEvent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
