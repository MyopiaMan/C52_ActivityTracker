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

    public List<UserBodyParameter> findAllUserBodyParametersByUser(User user){
        return userBodyParameterRepository.findAllUserBodyParametersByUser(user);
    }

    public Optional<UserBodyParameter> findAllUserBodyParametersByUser (String username){
        return userBodyParameterRepository.findByUsername(username);
    }

//    public List<UserBodyParameter> findAllUserBodyParametersByUserGender(UserGender userGender){
//        return userBodyParameterRepository.findAllUserBodyParametersByUserGender(userGender);
//    }
//
//    public List<UserBodyParameter> findAllUserBodyParametersByUserGenderAndAge(UserGender userGender, int age){
//        return userBodyParameterRepository.findAllUserBodyParametersByUserGenderAndAge(userGender, age);
//    }
//
//    public List<UserBodyParameter> findAllUserBodyParametersByWeight(BigDecimal weight){
//        return userBodyParameterRepository.findAllUserBodyParametersByWeight(weight);
//    }

    public void deleteUserBodyParameter(Long id){
        userBodyParameterRepository.deleteById(id);
    }
}
