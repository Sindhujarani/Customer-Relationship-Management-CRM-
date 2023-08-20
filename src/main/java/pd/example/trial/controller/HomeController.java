package pd.example.trial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import pd.example.trial.service.UserDetailsServiceImpl;


@Controller
public class HomeController {
    @Autowired
    private final UserDetailsServiceImpl userDetailsService;

    public HomeController(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/index")
    public String showHomePage () {
        return "index";
    }
    @GetMapping("/contact")
    public String showContactPage () {
        return "contact";
    }
    @GetMapping("/navigation")
    public String showNavigationPage () {
        return "navigation";
    }
    @GetMapping("/about")
    public String showAboutPage(){return "about";}
    @GetMapping("/login")
    public String showLoginPage () {
        return "login";
    }


    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/login";
    }
//@GetMapping("/logout")
//public String logout(SessionStatus sessionStatus) {
//    sessionStatus.setComplete();
//    return "redirect:/login";
//}
}
