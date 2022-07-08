package by.paliakou.c52_activitytracker.service;

import by.paliakou.c52_activitytracker.entity.UserGender;
import by.paliakou.c52_activitytracker.entity.parameters.UserBodyParameter;
import by.paliakou.c52_activitytracker.repository.UserBodyParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    public Optional<UserBodyParameter> findUserBodyParametersByGender(UserGender gender) {
        return userBodyParameterRepository.findByGender(gender);
    }

    public Optional<UserBodyParameter> findUserBodyParametersByAge(int age) {
        return userBodyParameterRepository.findByAge(age);
    }

    public Optional<UserBodyParameter> findUserBodyParametersByWeight(BigDecimal weight) {
        return userBodyParameterRepository.findByWeight(weight);
    }

    public Optional<UserBodyParameter> findUserBodyParametersByHeight(BigDecimal height) {
        return userBodyParameterRepository.findByHeight(height);
    }

    public Optional<UserBodyParameter> findBodyParametersById(Long id) {
        return userBodyParameterRepository.findByUserId(id);
    }
}
