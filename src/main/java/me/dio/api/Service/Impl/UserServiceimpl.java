package me.dio.api.Service.Impl;


import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.dio.api.Service.UserService;
import me.dio.api.domain.model.User;
import me.dio.api.domain.model.Repository.UserRepository;



@Service
public class UserServiceimpl implements UserService{

    private UserRepository userRepository;

    private UserServiceimpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User create(User userToCreate) {

        if(userRepository.existsByUserNumber(userToCreate.getUserNumber())){
            throw new NoSuchElementException("User with number " + userToCreate.getUserNumber() + " already exists!");
        }
        return userRepository.save(userToCreate);
    }

    @Override
    public User FindById(Long Id) {
        return userRepository.findById(Id)
        .orElseThrow(() -> new IllegalArgumentException("User not found with Id: " + Id));
    }

    
}
