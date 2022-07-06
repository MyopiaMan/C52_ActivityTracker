package by.paliakou.c52_activitytracker.repository;

import by.paliakou.c52_activitytracker.entity.User;
import by.paliakou.c52_activitytracker.entity.UserGender;
import by.paliakou.c52_activitytracker.entity.parameters.UserBodyParameter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface UserBodyParameterRepository extends JpaRepository<UserBodyParameter, Long> {

    List<UserBodyParameter> findAllUserBodyParametersByUser(User user);

    List<UserBodyParameter> findAllUserBodyParametersByUserGender(UserGender userGender);

    List<UserBodyParameter> findAllUserBodyParametersByUserGenderAndAge(UserGender userGender, int age);

    List<UserBodyParameter> findAllUserBodyParametersByWeight(BigDecimal weight);
}
