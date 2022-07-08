package by.paliakou.c52_activitytracker.service;

import by.paliakou.c52_activitytracker.entity.User;
import by.paliakou.c52_activitytracker.entity.parameters.UserHealthParameter;
import by.paliakou.c52_activitytracker.repository.UserHealthParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class UserHealthParameterService {
    @Autowired
    UserHealthParameterRepository userHealthParameterRepository;

    public UserHealthParameter save(UserHealthParameter userHealthParameter){
        return userHealthParameterRepository.save(userHealthParameter);
    }

    public void deleteUserHealthParameter(Long id){
        userHealthParameterRepository.deleteById(id);
    }

    public Optional<UserHealthParameter> findHealthParamsByUser(User user) {
        return userHealthParameterRepository.findByUser(user);
    }

    public Optional<UserHealthParameter> findHealthParamsByOxygenSaturation(int oxygenSaturation) {
        return userHealthParameterRepository.findByOxygenSaturation(oxygenSaturation);
    }

    public Optional<UserHealthParameter> findHealthParamsByBodyTemperature(BigDecimal bodyTemperature) {
        return userHealthParameterRepository.findByBodyTemperature(bodyTemperature);
    }

    public Optional<UserHealthParameter> findHealthParamsByPulse(int pulse) {
        return userHealthParameterRepository.findByPulse(pulse);
    }

    public Optional<UserHealthParameter> findHealthParametersById(Long id) {
        return userHealthParameterRepository.findById(id);
    }
}
