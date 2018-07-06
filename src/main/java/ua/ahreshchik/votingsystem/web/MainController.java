package ua.ahreshchik.votingsystem.web;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;
import ua.ahreshchik.votingsystem.to.UserTo;
import ua.ahreshchik.votingsystem.util.UserUtil;
import ua.ahreshchik.votingsystem.web.user.AbstractUserController;

import javax.validation.Valid;

@Controller
public class MainController extends AbstractUserController {

    @GetMapping("/")
    public String root() {
        return "redirect:restaurants";
    }

    @GetMapping("/restaurants")
    public String restaurants() {
        return "restaurants";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(ModelMap modelMap) {
        modelMap.addAttribute("userTo", new UserTo());
        return "registration";
    }

    @PostMapping("/register")
    public String saveRegistration(@Valid UserTo userTo, BindingResult bindingResult, SessionStatus status, ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        try {
            super.create(UserUtil.createNewFromTo(userTo));
            status.setComplete();
            return "redirect:login"; //"redirect:login?message=app.registered&username=" + userTo.getEmail();
        } catch (DataIntegrityViolationException e) {
            bindingResult.rejectValue("email", "User with this email already exists");
            return "registration";
        }
    }

}
