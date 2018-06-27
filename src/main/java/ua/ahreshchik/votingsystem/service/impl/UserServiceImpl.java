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
    UserRepository repository;

    @Override
    public User create(User user) {
        Assert.notNull(user, "user must be not null");
        //prepare to save
        return repository.save(user);
    }

    @Override
    public User get(int id) throws NotFoundException {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(int id) throws NotFoundException {
        repository.delete(id);

    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        return repository.getByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User getWithVotes(int id) {
        return repository.getWithVotes(id);
    }
}
