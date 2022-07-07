package by.paliakou.c52_activitytracker.repository;

import by.paliakou.c52_activitytracker.entity.User;
import by.paliakou.c52_activitytracker.entity.parameters.UserHealthParameter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface UserHealthParameterRepository extends JpaRepository<UserHealthParameter, Long> {

    Optional<UserHealthParameter> findHealthParametersByUser(User user);

    Optional<UserHealthParameter> findHealthParametersByOxygenSaturation(int oxygenSaturation);

    Optional<UserHealthParameter> findHealthParametersByBodyTemperature(BigDecimal bodyTemperature);

    Optional<UserHealthParameter> findHealthParametersByPulse(int pulse);

    Optional<UserHealthParameter> findHealthParametersById(Long id);
}
