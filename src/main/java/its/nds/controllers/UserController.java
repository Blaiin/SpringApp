package its.nds.controllers;

import its.nds.model.User;
import its.nds.services.RegistrationServices;
import its.nds.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class UserController {

    private final UserServices userService;
    private final RegistrationServices registrationServices;

    @Autowired
    public UserController(UserServices userService, RegistrationServices registrationServices) {
        this.userService = userService;
        this.registrationServices = registrationServices;
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
            return "error";
        }
    }
    @PostMapping("/register")
    public String registerUser(@RequestParam String name,
                               @RequestParam String surname,
                               @RequestParam String phone,
                               @RequestParam String email,
                               @RequestParam String birthdate,
                               @RequestParam String password) {
        User userToRegister = User.builder()
                                .name(name)
                                .surname(surname)
                                .phone(phone)
                                .email(email)
                                .dateOfBirth(LocalDateTime.parse(birthdate))
                                .build();
        if(userService.registerUser(userToRegister)) {
            if(registrationServices.registerEncryptPassForUser(userToRegister, password)){
                return "redirect:user-list";
            }
        }
        return "register";
    }
}
