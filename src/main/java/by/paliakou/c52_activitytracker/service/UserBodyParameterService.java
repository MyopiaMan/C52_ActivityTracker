package by.paliakou.c52_activitytracker.service;

import by.paliakou.c52_activitytracker.entity.User;
import by.paliakou.c52_activitytracker.entity.UserGender;
import by.paliakou.c52_activitytracker.entity.parameters.UserBodyParameter;
import by.paliakou.c52_activitytracker.repository.UserBodyParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class UserBodyParameterService {

    @Autowired
    UserBodyParameterRepository userBodyParameterRepository;

    public UserBodyParameter save(UserBodyParameter userBodyParameter){
        return userBodyParameterRepository.save(userBodyParameter);
    }

    public void deleteUserBodyParameter(Long id){
        userBodyParameterRepository.deleteById(id);
    }

    public Optional<UserBodyParameter> findUserBodyParametersByGender(UserGender userGender) {
        return userBodyParameterRepository.findByUserGender(userGender);
    }

    public Optional<UserBodyParameter> findUserBodyParametersByAge(int userAge) {
        return userBodyParameterRepository.findUserBodyParametersByUserAge(userAge);
    }

    public Optional<UserBodyParameter> findUserBodyParametersByWeight(BigDecimal userWeight) {
        return userBodyParameterRepository.findUserBodyParametersByUserWeight(userWeight);
    }

    public Optional<UserBodyParameter> findUserBodyParametersByHeight(BigDecimal userHeight) {
        return userBodyParameterRepository.findUserBodyParametersByUserHeight(userHeight);
    }

    public Optional<UserBodyParameter> findBodyParametersById(Long id) {
        return userBodyParameterRepository.findUserBodyParametersByUserId(id);
    }
}
