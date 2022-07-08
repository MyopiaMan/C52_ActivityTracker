package by.paliakou.c52_activitytracker.repository;

import by.paliakou.c52_activitytracker.entity.User;
import by.paliakou.c52_activitytracker.entity.UserGender;
import by.paliakou.c52_activitytracker.entity.parameters.UserBodyParameter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface UserBodyParameterRepository extends JpaRepository<UserBodyParameter, Long> {

    Optional<UserBodyParameter> findByGender(UserGender gender);

    Optional<UserBodyParameter> findByAge(int age);

    Optional<UserBodyParameter> findByWeight(BigDecimal weight);

    Optional<UserBodyParameter> findByHeight(BigDecimal height);

    Optional<UserBodyParameter> findByUserId(Long id);
}
