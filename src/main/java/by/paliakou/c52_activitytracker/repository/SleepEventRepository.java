package by.paliakou.c52_activitytracker.repository;

import by.paliakou.c52_activitytracker.entity.SleepEvent;
import by.paliakou.c52_activitytracker.entity.StageOfSleep;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SleepEventRepository extends JpaRepository<SleepEvent, Long> {

    Optional<SleepEvent> findSleepEventsByStage(StageOfSleep stage);

    Optional<SleepEvent> findSleepEventsByRating(int rating);
}
