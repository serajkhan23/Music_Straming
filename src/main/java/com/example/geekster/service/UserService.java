package com.example.geekster.service;

import com.example.geekster.dto.PasswordEncoder;
import com.example.geekster.dto.PasswordMatcher;
import com.example.geekster.dto.SignUpOutput;
import com.example.geekster.model.User;
import com.example.geekster.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final PasswordMatcher passwordMatcher;
    @Autowired
    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder,PasswordMatcher passwordMatcher) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.passwordMatcher=passwordMatcher;
    }

    public boolean verifyUserCredentials(String userEmail, String userPassword) {
        User existingUser = userRepo.findByUserEmail(userEmail);
        if (existingUser == null) {
            return false; // User not found
        }

        String hashedPassword = passwordEncoder.encodePassword(userPassword);
        String storedPassword = existingUser.getUserPassword();
        return passwordMatcher.passwordMatcher(hashedPassword, storedPassword);
    }

    public SignUpOutput adduser(User user) {
        boolean signUpStatus = true;
        String signUpMsg = null;
        String signUpEmail = user.getUserEmail();
        User existingUser = userRepo.findByUserEmail(signUpEmail);
        if (existingUser != null) {
            signUpStatus = false;
            signUpMsg = "Email already registered.";
            return new SignUpOutput(signUpStatus, signUpMsg);
        }
        String hashedPassword = passwordEncoder.encodePassword(user.getUserPassword());
        user.setUserPassword(hashedPassword);
        userRepo.save(user);
        signUpMsg = "Success";
        return new SignUpOutput(signUpStatus, signUpMsg);
    }


    public User getUserByEmail(String email) {
        return userRepo.findByUserEmail(email);
    }

    public void saveUser(User user) {
        userRepo.save(user);
    }

}
