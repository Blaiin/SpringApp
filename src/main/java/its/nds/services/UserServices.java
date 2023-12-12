package its.nds.services;

import its.nds.repositories.UserRepository;
import its.nds.model.User;
import its.nds.utils.LogUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServices {
    private final UserRepository userRepository;
    private static final Logger logger = LogUtils.getLogger();
    private static final String RFC_EMAIL_REGEX = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    private static final String PHONE_REGEX = "^\\+?\\s*[0-9]{2,12}$";

    @Autowired
    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
        logger.info("UserServices initialized.");
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public boolean registerUser(User user) {
        if(isValidEmail(user.getEmail()) && isValidPhone(user.getPhone())) {
            if (isEmailUnique(user.getEmail()) && isPhoneUnique(user.getPhone())) {
                try {
                    userRepository.save(user);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return false;
    }


    private boolean isEmailUnique(String email) {
        return userRepository.findUserByEmail(email) == null;
    }

    private boolean isPhoneUnique(String phone) {
        return userRepository.findUserByPhone(phone) == null;
    }
    private boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(RFC_EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    private boolean isValidPhone(String phone) {
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }
}
