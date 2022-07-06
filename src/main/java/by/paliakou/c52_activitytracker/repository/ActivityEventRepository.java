package by.paliakou.c52_activitytracker.repository;

import by.paliakou.c52_activitytracker.entity.ActivityEvent;
import by.paliakou.c52_activitytracker.entity.TypeOfActivity;
import by.paliakou.c52_activitytracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityEventRepository extends JpaRepository<ActivityEvent, Long> {
    List<ActivityEvent> findAllActivityEventsByUser(User user);

    List<ActivityEvent> findAllActivityEventsByUserAndTypeOfActivity(User user, TypeOfActivity typeOfActivity);
}
