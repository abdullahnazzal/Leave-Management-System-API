package com.example.Leave.Management.System.user;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository studentRepository;
    // private final User user;

    public UserService(UserRepository studentRepository) {
        this.studentRepository = studentRepository;
        // this.user = user;
    }

    public List<User> getUser() {
        return studentRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userOptional = studentRepository.findUserByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("email taken!");
        }
        studentRepository.save(user);
    }

    public void removeUser(Long id) {
        boolean exists = studentRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("User id : " + id + " does not exists!");
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateUser(Long id, String userName) {
        // boolean exists = studentRepository.existsById(id);
        User user = studentRepository.findById(id).orElseThrow(() -> {
            throw new IllegalStateException("User id : " + id + " does not exists!");
        });

        if (userName != null &&
                userName.length() > 0 &&
                !Objects.equals(user.getUserName(), userName)) {
            user.setUserName(userName);
        }
        else{
            throw new IllegalStateException("This userName is taken!");
        }
        // if (userName != null &&
        //         userName.length() > 0 &&
        //         !Objects.equals(user.getUserName(), userName)) {
        //     Optional<User> userOptional = studentRepository.findUserByUserName(userName);
        //     if (userOptional.isPresent()) {
        //         throw new IllegalStateException("userName taken!");

        //     }
        //     user.setUserName(userName);
        // }
    }
}
