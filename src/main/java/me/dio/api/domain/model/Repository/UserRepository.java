package me.dio.api.domain.model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dio.api.domain.model.UserNumber;
import me.dio.api.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    boolean existsByUserNumber(UserNumber Number);
    
}
