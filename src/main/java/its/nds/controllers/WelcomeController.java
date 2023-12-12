package its.nds.controllers;


import its.nds.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
    private final UserRepository userRepository;
    @Autowired
    public WelcomeController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping(value = "/")
    public String welcomePage(Model model) {
        model.addAttribute("registeredUserCount", userRepository.countUserRecords());
        return "welcome";
    }

    @GetMapping(value = "/login")
    public String loginPage() { return "login";}

    @GetMapping(value = "/register")
    public String registerPage() { return "register";}
}

