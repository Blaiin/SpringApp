package its.nds.controllers;

import its.nds.model.Registration;
import its.nds.model.User;
import its.nds.repositories.RegistrationRepository;
import its.nds.repositories.UserRepository;
import its.nds.services.RegistrationServices;
import its.nds.services.UserServices;
import its.nds.utils.DateUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class UserController {

    private final UserServices userService;
    private final RegistrationServices registrationServices;
    private final UserRepository userRepository;
    private final RegistrationRepository registrationRepository;

    @Autowired
    public UserController(UserServices userService, RegistrationServices registrationServices,
                          UserRepository userRepository,
                          RegistrationRepository registrationRepository) {
        this.userService = userService;
        this.registrationServices = registrationServices;
        this.userRepository = userRepository;
        this.registrationRepository = registrationRepository;
    }
    @GetMapping("/user-list")
    public String showUserList(Model model) {
        try {
            List<User> users = userService.getAllUsers();

            if (users != null) {
                model.addAttribute("users", users);
                return "user-list";
            } else {
                // Handle the case where the list is null
                return "error"; // You can redirect to an error page or handle it in some way
            }
        } catch (Exception e) {
            model.addAttribute("error", e);
            e.printStackTrace();
            return "error";
        }
    }
    @PostMapping("/login")
    public String loginUser(@RequestParam(name = "email") String email,
                            @RequestParam(name = "password") String password,
                            Model model) {
        User user = userRepository.findUserByEmail(email);
        if(user != null) {
            Registration registration = registrationRepository.findRegistrationByEmail(email);
            String userSalt = registration.getSalt();
            if(registration.getEncrypt_pass().equals(BCrypt.hashpw(password, userSalt))) {
                model.addAttribute("name", user.getName());
                model.addAttribute("surname", user.getSurname());
                model.addAttribute("registeredOn", DateUtils.formatDateToLocal(registration.getRegisteredOn()));
                return "welcomeLoggedIn";
            }
        }
        return "welcomeLoggedIn";
    }
    @PostMapping("/register")
    public String registerUser(@RequestParam(name = "name") String name,
                               @RequestParam(name = "surname") String surname,
                               @RequestParam(name = "phone") String phone,
                               @RequestParam(name = "email") String email,
                               @RequestParam(name = "birthdate") String birthdate,
                               @RequestParam(name = "password") String password) {
        LocalDate formattedDoB = LocalDate.parse(DateUtils.formatDateToLocal(LocalDate.parse(birthdate)));
        User userToRegister = User.builder()
                                .name(name)
                                .surname(surname)
                                .phone(phone)
                                .email(email)
                                .dateOfBirth(formattedDoB)
                                .build();
        if(userService.registerUser(userToRegister)) {
            if(registrationServices.registerEncryptPassForUser(userToRegister, password)){
                System.out.printf("User %s registered.", userToRegister.getEmail());
                return "redirect:user-list";
            }
        }
        System.out.printf("Could not register user: %s", userToRegister.getEmail());
        return "register";
    }
}
