package by.paliakou.c52_activitytracker.repository;

import by.paliakou.c52_activitytracker.entity.User;
import by.paliakou.c52_activitytracker.entity.UserGender;
import by.paliakou.c52_activitytracker.entity.parameters.UserBodyParameter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface UserBodyParameterRepository extends JpaRepository<UserBodyParameter, Long> {

    Optional<UserBodyParameter> findByUserGender(UserGender userGender);

    List<UserBodyParameter> findAllUserBodyParametersByUser(User user);

    List<UserBodyParameter> findAllUserBodyParametersByUserGender(UserGender userGender);

    List<UserBodyParameter> findAllUserBodyParametersByUserGenderAndAge(UserGender userGender, int age);

    List<UserBodyParameter> findAllUserBodyParametersByWeight(BigDecimal weight);

    Optional<UserBodyParameter> findUserBodyParametersByUserAge(int userAge);

    Optional<UserBodyParameter> findUserBodyParametersByUserWeight(BigDecimal userWeight);

    Optional<UserBodyParameter> findUserBodyParametersByUserHeight(BigDecimal userHeight);
}
