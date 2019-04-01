/*
Creates methods for user queries
 */

package com.project.library.service.entityServices;

import com.project.library.DAOs.UserRepository;
import com.project.library.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    // autowire UserRepo
    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository theUserRepository){userRepository = theUserRepository;}

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // search for user based on username
    @Override
    public User findById(int username) {
        // Search for user based on username
        Optional<User> result = userRepository.findById(username);

        // In case the user isn't found, throw runtime exception
        User theUser = null;
        if(result.isPresent()){
            theUser = result.get();
        }
        else {
            throw new RuntimeException("Did not find user id");
        }

        return theUser;
    }
}
