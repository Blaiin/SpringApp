package its.nds.services;

import its.nds.model.Registration;
import its.nds.model.User;
import its.nds.repositories.RegistrationRepository;
import its.nds.repositories.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationServices {
    private final RegistrationRepository registrationRepository;
    private final UserRepository userRepository;
    private static final Logger logger = LogManager.getLogger(RegistrationServices.class);

    @Autowired
    public RegistrationServices(RegistrationRepository registrationRepository, UserRepository userRepository) {
        this.registrationRepository = registrationRepository;
        this.userRepository = userRepository;
    }
    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }
    public boolean registerEncryptPassForUser(User registeredUser, String pass) {
        User user = userRepository.findUserByEmail(registeredUser.getEmail());
        String salt = BCrypt.gensalt();
        if(user != null) {
            Registration registration = Registration.builder()
                                        .user_id(user.getId())
                                        .user_email(user.getEmail())
                                        .encrypt_pass(BCrypt.hashpw(pass, salt))
                                        .salt(salt)
                                        .build();
             registrationRepository.save(registration);
             return true;
        }
        return false;
    }

}
