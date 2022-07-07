package by.paliakou.c52_activitytracker.service;

import by.paliakou.c52_activitytracker.entity.*;
import by.paliakou.c52_activitytracker.repository.SleepEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SleepEventService {

    @Autowired
    private SleepEventRepository sleepEventRepository;

    public SleepEvent save(SleepEvent sleepEvent){
        return sleepEventRepository.save(sleepEvent);
    }

    public void deleteSleepEvent(Long id){
        sleepEventRepository.deleteById(id);
    }

    public Optional<SleepEvent> findSleepEventsByStage(StageOfSleep stage) {
        return sleepEventRepository.findSleepEventsByStage(stage);
    }

    public Optional<SleepEvent> findSleepEventsByRating(int rating) {
        return sleepEventRepository.findSleepEventsByRating(rating);
    }

    public Optional<SleepEvent> findSleepEventById(Long id) {
        return sleepEventRepository.findById(id);
    }//???
}
