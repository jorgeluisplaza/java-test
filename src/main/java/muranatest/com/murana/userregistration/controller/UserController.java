package muranatest.com.murana.userregistration.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import muranatest.com.murana.userregistration.model.User;
import muranatest.com.murana.userregistration.service.UserServiceImpl;
import muranatest.com.murana.userregistration.util.EmailAlreadyExistsException;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@Valid @RequestBody User user) {

        try {
            User registeredUser = userService.registerUser(user);
            return new ResponseEntity<>(getResponseMap(registeredUser), HttpStatus.CREATED);
        } catch(EmailAlreadyExistsException e) {
            return new ResponseEntity<>(getErrorMap("El correo electrónico ya está registrado", 400) , HttpStatus.BAD_REQUEST);
        }
    }

        private java.util.Map<String, Object> getResponseMap(User user) {
            Map<String, Object> responseMap = new HashMap<>();
            responseMap.put("name", user.getName());
            responseMap.put("email", user.getEmail());
            responseMap.put("created", LocalDateTime.now());
            responseMap.put("modified", LocalDateTime.now());
            responseMap.put("last_login", LocalDateTime.now());
            responseMap.put("id", user.getId());
            responseMap.put("token", user.getId());
            responseMap.put("isactive", true); // Puedes determinar la activación según tu lógica

            return responseMap;
        }

        private java.util.Map<String, Object> getErrorMap(String msj, Number errorCode) {

            Map<String, Object> errorMap = new HashMap<>();
            errorMap.put("message", msj);
            errorMap.put("code", errorCode);

            return errorMap;
        }
}
