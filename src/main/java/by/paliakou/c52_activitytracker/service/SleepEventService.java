package by.paliakou.c52_activitytracker.service;

import by.paliakou.c52_activitytracker.entity.*;
import by.paliakou.c52_activitytracker.repository.SleepEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SleepEventService {

    @Autowired
    private SleepEventRepository sleepEventRepository;

    public SleepEvent save(SleepEvent sleepEvent){
        return sleepEventRepository.save(sleepEvent);
    }

    public List<SleepEvent> findAllSleepEventsByUser(User user){
        return sleepEventRepository.findAllSleepEventsByUser(user);
    }

    public List<SleepEvent> findAllSleepEventsByUserAndStageOfSleep(User user,
                                                                            StageOfSleep stageOfSleep){
        return sleepEventRepository.findAllSleepEventsByUserAndStageOfSleep(user, stageOfSleep);
    }

    public List<SleepEvent> findAllSleepEventsByUserAndRating(User user, int rating){
        return sleepEventRepository.findAllSleepEventsByUserAndRating(user, rating);
    }

    public void deleteSleepEvent(Long id){
        sleepEventRepository.deleteById(id);
    }
}
