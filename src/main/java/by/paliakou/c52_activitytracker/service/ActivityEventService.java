package by.paliakou.c52_activitytracker.service;

import by.paliakou.c52_activitytracker.entity.ActivityEvent;
import by.paliakou.c52_activitytracker.entity.TypeOfActivity;
import by.paliakou.c52_activitytracker.entity.User;
import by.paliakou.c52_activitytracker.repository.ActivityEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityEventService {
    @Autowired
    private ActivityEventRepository activityEventRepository;

    public ActivityEvent save(ActivityEvent activityEvent){
        return activityEventRepository.save(activityEvent);
    }

    public List<ActivityEvent> findAllActivityEventsByUser(User user){
        return activityEventRepository.findAllActivityEventsByUser(user);
    }

    public List<ActivityEvent> findAllActivityEventsByUserAndTypeOfActivity(User user,
                                                                            TypeOfActivity typeOfActivity){
        return activityEventRepository.findAllActivityEventsByUserAndTypeOfActivity(user, typeOfActivity);
    }

    public void deleteActivityEvent(Long id){
        activityEventRepository.deleteById(id);
    }
}
