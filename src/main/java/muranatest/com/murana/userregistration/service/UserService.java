package muranatest.com.murana.userregistration.service;

import java.util.UUID;

import muranatest.com.murana.userregistration.model.User;

public interface UserService {
    User registerUser(User user);
    User getUser(UUID id);
} 
