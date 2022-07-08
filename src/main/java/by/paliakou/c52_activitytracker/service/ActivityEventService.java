package by.paliakou.c52_activitytracker.service;

import by.paliakou.c52_activitytracker.entity.ActivityEvent;
import by.paliakou.c52_activitytracker.entity.TypeOfActivity;
import by.paliakou.c52_activitytracker.entity.User;
import by.paliakou.c52_activitytracker.repository.ActivityEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityEventService {
    @Autowired
    private ActivityEventRepository activityEventRepository;

    public ActivityEvent save(ActivityEvent activityEvent){
        return activityEventRepository.save(activityEvent);
    }

    public void deleteActivityEvent(Long id){
        activityEventRepository.deleteById(id);
    }

    public Optional<ActivityEvent> findActivityEventByUser(User user) {
        return activityEventRepository.findActivityEventByUser(user);
    }

    public Optional<ActivityEvent> findActivityEventByType(TypeOfActivity type) {
        return activityEventRepository.findActivityEventByType(type);
    }

    public Optional<ActivityEvent> findActivityEventByDistance(int distance) {
        return activityEventRepository.findActivityEventByDistance(distance);
    }

    public Optional<ActivityEvent> findActivityEventBySpeed(int speed) {
        return activityEventRepository.findActivityEventBySpeed(speed);
    }

    public Optional<ActivityEvent> findActivityEventByActivityPulse(int activityPulse) {
        return activityEventRepository.findActivityEventByActivityPulse(activityPulse);
    }

    public Optional<ActivityEvent> findActivityEventByEnergy(BigDecimal activityEnergy) {
        return activityEventRepository.findActivityEventByActivityEnergy(activityEnergy);
    }

    public Optional<ActivityEvent> findActivityEventById(Long id) {
        return activityEventRepository.findById(id);
    }//???
}
