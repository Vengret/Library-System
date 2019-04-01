package com.project.library.service.entityServices;

import com.project.library.entities.User;

public interface UserService {
    User findByUsername(String username);
    User findById(int theId);
}
