package by.paliakou.c52_activitytracker.service;

import by.paliakou.c52_activitytracker.entity.User;
import by.paliakou.c52_activitytracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }

    public Optional<User> findUserByUsername (String username){
        return userRepository.findByUsername(username);
    }

    public Optional<User> findById (Long id){
        return userRepository.findById(id);
    }
}
