package by.paliakou.c52_activitytracker.repository;

import by.paliakou.c52_activitytracker.entity.User;
import by.paliakou.c52_activitytracker.entity.parameters.UserHealthParameter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserHealthParameterRepository extends JpaRepository<UserHealthParameter, Long> {


    List<UserHealthParameter> findAllUserHealthParametersByUser(User user);

    List<UserHealthParameter> findAllUserBodyParametersByUserAndPulse(User user, int pulse);
}
