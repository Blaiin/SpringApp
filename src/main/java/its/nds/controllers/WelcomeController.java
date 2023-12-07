package its.nds.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
    @GetMapping(value = "/")
    public String welcomePage() {
        return "welcome";
    }

    @GetMapping(value = "/login")
    public String loginPage() { return "login";}

    @GetMapping(value = "/register")
    public String registerPage() { return "register";}
}

