package Services;

import DTOs.UserRegistrationDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Repos.UserRepository;
import Model.User;
import Hashing.PasswordHasher;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordHasher passwordHasher;

    @Autowired
    public UserService(UserRepository userRepository,PasswordHasher passwordHasher) {
        this.userRepository = userRepository;
        this.passwordHasher = passwordHasher;
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    @Transactional
    public User registerUser(UserRegistrationDto userDto) {
        User user = convertDtoToEntity(userDto);
        return userRepository.save(user);
    }

    private User convertDtoToEntity(UserRegistrationDto userDto) {
        User user = new User();
        user.setName(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setHashedPassword(passwordHasher.hashPassword(userDto.getPassword()));
        user.setAddress(userDto.getAddress());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setRole(User.Role.CUSTOMER);
        return user;
    }

    public boolean loginUser(String usernameOrEmail,String password) {
        User user;
        if (usernameOrEmail.contains("@")) {
            user = userRepository.findByEmail(usernameOrEmail);
        } else {
            user = userRepository.findByName(usernameOrEmail);
        }
        if (user != null && passwordHasher.matches(password, user.getHashedPassword())) {
            return true;
        }
        return false;
    }

}
