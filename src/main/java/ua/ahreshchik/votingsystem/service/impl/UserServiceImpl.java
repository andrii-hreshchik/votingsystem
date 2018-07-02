package ua.ahreshchik.votingsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ua.ahreshchik.votingsystem.model.User;
import ua.ahreshchik.votingsystem.repository.UserRepository;
import ua.ahreshchik.votingsystem.service.UserService;
import ua.ahreshchik.votingsystem.util.exception.NotFoundException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User create(User user) {
        Assert.notNull(user, "user must be not null");
        //prepare to save
        return userRepository.save(user);
    }

    @Override
    public User get(int id) throws NotFoundException {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void update(User user) {
        //checkNotFound
        Assert.notNull(user, "user must not be null");
        userRepository.save(user);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        userRepository.delete(id);

    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        Assert.notNull(email, "email must not be null");
        return userRepository.getByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getWithVotes(int id) {
        return userRepository.getWithVotes(id);
    }
}
