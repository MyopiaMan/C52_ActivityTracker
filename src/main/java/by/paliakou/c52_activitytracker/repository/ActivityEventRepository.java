package by.paliakou.c52_activitytracker.repository;

import by.paliakou.c52_activitytracker.entity.ActivityEvent;
import by.paliakou.c52_activitytracker.entity.TypeOfActivity;
import by.paliakou.c52_activitytracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ActivityEventRepository extends JpaRepository<ActivityEvent, Long> {
    List<ActivityEvent> findAllActivityEventsByUser(User user);

    List<ActivityEvent> findAllActivityEventsByUserAndTypeOfActivity(User user, TypeOfActivity typeOfActivity);

    Optional<ActivityEvent> findActivityEventByUser(User user);

    Optional<ActivityEvent> findActivityEventByType(TypeOfActivity type);

    Optional<ActivityEvent> findActivityEventByDistance(int distance);

    Optional<ActivityEvent> findActivityEventBySpeed(int speed);

    Optional<ActivityEvent> findActivityEventByPulse(int activityPulse);

    Optional<ActivityEvent> findActivityEventByEnergy(int activityEnergy);

}
