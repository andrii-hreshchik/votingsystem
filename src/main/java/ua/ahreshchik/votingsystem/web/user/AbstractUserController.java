package ua.ahreshchik.votingsystem.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ua.ahreshchik.votingsystem.model.User;
import ua.ahreshchik.votingsystem.service.UserService;
import ua.ahreshchik.votingsystem.to.UserTo;
import ua.ahreshchik.votingsystem.util.exception.NotFoundException;

import java.util.List;

import static ua.ahreshchik.votingsystem.util.ValidationUtil.checkNew;

public abstract class AbstractUserController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    public User create(User user) {
        log.info("create user {}", user);
        checkNew(user);
        return userService.create(user);
    }

    public User get(int id) throws NotFoundException {
        log.info("get user with if = {}", id);
        return userService.get(id);
    }

    public void update(User user) {

    }

    public void update(UserTo user) {

    }

    public void delete(int id) throws NotFoundException {

    }

    public User getByEmail(String email) throws NotFoundException {
        log.info("get by email = {}", email);
        return userService.getByEmail(email);
    }

    public List<User> getAll() {
        log.info("get all users");
        return userService.getAll();
    }

    public User getWithVotes(int id) {
        return null;
    }
}
