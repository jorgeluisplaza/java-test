package muranatest.com.murana.userregistration.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import muranatest.com.murana.userregistration.model.User;
import muranatest.com.murana.userregistration.repository.UserRepository;
import muranatest.com.murana.userregistration.util.EmailAlreadyExistsException;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {

        if (emailExists(user.getEmail())) {
            throw new EmailAlreadyExistsException("El correo electrónico ya está registrado");
        }

        return userRepository.save(user);
    }

    @Override
    public User getUser(UUID id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }
    
    private boolean emailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
