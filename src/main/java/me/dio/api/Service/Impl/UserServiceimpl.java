package me.dio.api.Service.Impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.dio.api.Controller.Exception.BusinessException;
import me.dio.api.Service.UserService;
import me.dio.api.domain.model.User;
import me.dio.api.domain.model.Repository.UserRepository;

@Service
public class UserServiceimpl implements UserService {

    private static final Long UNCHANGEABLE_USER_ID = 1L;

    private UserRepository userRepository;
    private UserServiceimpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }
    
    @Override
    public User findById(Long Id) {
        return userRepository.findById(Id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with Id: " + Id));
    }

    @Override
    public User create(User userToCreate) {

        if (userRepository.existsByUserNumber(userToCreate.getUserNumber())) {
            throw new NoSuchElementException("User with number " + userToCreate.getUserNumber() + " already exists!");
        }
        return userRepository.save(userToCreate);
    }

    

    @Override
    public User update(Long id, User userToUpdate) {
        this.validateChangeableId(id, "updated");
        User dbUser = this.findById(id);
        if (!dbUser.getId().equals(userToUpdate.getId())) {
            throw new BusinessException("Update IDs must be the same.");
        }

        dbUser.setName(userToUpdate.getName());
        dbUser.setConsultation(userToUpdate.getConsultation());
        dbUser.setUserNumber(userToUpdate.getUserNumber());
        dbUser.setPaymentMethod(userToUpdate.getPaymentMethod());
        dbUser.setValue(userToUpdate.getValue());
        dbUser.setFeatures(userToUpdate.getFeatures());

        return dbUser;
    }

    private void validateChangeableId(Long id, String operation) {
        if (UNCHANGEABLE_USER_ID.equals(id)) {
            throw new BusinessException("User with ID %d can not be %s.".formatted(UNCHANGEABLE_USER_ID, operation));
        }
    }

    @Override
    public void delete(Long id) {
        this.validateChangeableId(id, "deleted");
        User dbUser = this.findById(id);
        this.userRepository.delete(dbUser);

    }
}
