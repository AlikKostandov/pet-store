package com.project.pet.store.services;


import com.project.pet.store.entities.User;
import com.project.pet.store.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    UserRepository userRepository;

    public User saveOrUpdate(User user){
        return userRepository.save(user);
    }
}
