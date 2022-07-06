package by.paliakou.c52_activitytracker.service;

import by.paliakou.c52_activitytracker.entity.User;
import by.paliakou.c52_activitytracker.entity.UserGender;
import by.paliakou.c52_activitytracker.entity.parameters.UserHealthParameter;
import by.paliakou.c52_activitytracker.repository.UserHealthParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserHealthParameterService {
    @Autowired
    UserHealthParameterRepository userHealthParameterRepository;

    public UserHealthParameter save(UserHealthParameter userHealthParameter){
        return userHealthParameterRepository.save(userHealthParameter);
    }

    public List<UserHealthParameter> findAllUserHealthParametersByUser(User user){
        return userHealthParameterRepository.findAllUserHealthParametersByUser(user);
    }

    public List<UserHealthParameter> findAllUserHealthParametersByUserAndPulse(User user, int pulse){
        return userHealthParameterRepository.findAllUserBodyParametersByUserAndPulse(user, pulse);
    }

    public void deleteUserHealthParameter(Long id){
        userHealthParameterRepository.deleteById(id);
    }
}
