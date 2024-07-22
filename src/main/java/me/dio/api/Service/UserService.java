package me.dio.api.Service;

import me.dio.api.domain.model.User;

public interface UserService {

    User FindById(Long Id);

    User create(User userToCreate);
    
} 
