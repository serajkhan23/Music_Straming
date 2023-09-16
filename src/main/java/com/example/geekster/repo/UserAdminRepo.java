package com.example.geekster.repo;

import com.example.geekster.model.UserAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAdminRepo extends JpaRepository<UserAdmin,Long> {
    UserAdmin findByUserAdminEmail(String userAdminEmail);
}