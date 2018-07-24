package ua.ahreshchik.votingsystem.web;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import ua.ahreshchik.votingsystem.service.DBService;
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

    //    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/votes")
    public String votes() {
        return "votesList";
    }

    @GetMapping("/authError")
    public String authError() {
        return "authError";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/administration")
    public String administration() {
        return "admin";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/populateDB")
    public String populateDB() {
        DBService.populateDB();
        return "redirect:restaurants";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/updateMenu")
    public String updateMenu(ModelMap modelMap, @RequestParam(value = "id") int id) {
        modelMap.addAttribute("restaurantId",id);
        return "adminMenu";
    }

    @PostMapping("/register")
    public String saveRegistration(@Valid UserTo userTo, BindingResult bindingResult, SessionStatus status, ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        try {
            super.create(UserUtil.createNewFromTo(userTo));
            status.setComplete();
            return "redirect:login";
        } catch (DataIntegrityViolationException e) {
            bindingResult.rejectValue("email", "User with this email already exists");
            return "registration";
        }
    }

}
