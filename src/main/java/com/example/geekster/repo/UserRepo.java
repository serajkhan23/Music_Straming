package com.example.geekster.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.geekster.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    User findByUserEmail(String userEmail);

}