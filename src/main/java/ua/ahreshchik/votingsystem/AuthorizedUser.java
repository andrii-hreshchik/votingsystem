package ua.ahreshchik.votingsystem;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import ua.ahreshchik.votingsystem.model.User;
import ua.ahreshchik.votingsystem.to.UserTo;
import ua.ahreshchik.votingsystem.util.UserUtil;

import java.util.Objects;

public class AuthorizedUser extends org.springframework.security.core.userdetails.User {
    private static final long serialVersionUID = 1L;

    private UserTo userTo;

    public AuthorizedUser(User user) {
        super(user.getEmail(), user.getPassword(), true, true, true, true, user.getRoles());
        this.userTo = UserUtil.asTo(user);
    }

    public static AuthorizedUser safeGet() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        } else {
            Object principal = authentication.getPrincipal();
            return (principal instanceof AuthorizedUser) ? (AuthorizedUser) principal : null;
        }
    }

    public static AuthorizedUser get() {
        AuthorizedUser authorizedUser = safeGet();
        Objects.requireNonNull(authorizedUser, "Authorized user not found");
        return authorizedUser;
    }

    public int getId() {
        return userTo.getId();
    }

    public static int id() {
        return get().userTo.getId();
    }


    public void update(UserTo newTo) {
        userTo = newTo;
    }

    public UserTo getUserTo() {
        return userTo;
    }

    @Override
    public String toString() {
        return userTo.toString();
    }

}
