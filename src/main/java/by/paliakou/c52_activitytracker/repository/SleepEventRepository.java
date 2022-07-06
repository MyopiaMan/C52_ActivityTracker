package by.paliakou.c52_activitytracker.repository;

import by.paliakou.c52_activitytracker.entity.SleepEvent;
import by.paliakou.c52_activitytracker.entity.StageOfSleep;
import by.paliakou.c52_activitytracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SleepEventRepository extends JpaRepository<SleepEvent, Long> {
    List<SleepEvent> findAllSleepEventsByUser(User user);

    List<SleepEvent> findAllSleepEventsByUserAndStageOfSleep(User user, StageOfSleep stageOfSleep);

    List<SleepEvent> findAllSleepEventsByUserAndRating(User user, int rating);
}
