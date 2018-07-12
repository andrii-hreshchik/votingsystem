package ua.ahreshchik.votingsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ua.ahreshchik.votingsystem.model.Vote;
import ua.ahreshchik.votingsystem.repository.VoteRepository;
import ua.ahreshchik.votingsystem.service.VoteService;
import ua.ahreshchik.votingsystem.util.exception.NotFoundException;

import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {


    private VoteRepository voteRepository;

    @Autowired
    public VoteServiceImpl(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @Override
    public Vote create(Vote vote) {
        Assert.notNull(vote, "vote must not be null");
        return voteRepository.save(vote);
    }

    @Override
    public Vote get(int id) throws NotFoundException {
        return voteRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Vote vote) {
        Assert.notNull(vote, "vote must not be null");
        voteRepository.save(vote);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        voteRepository.delete(id);
    }

    @Override
    public List<Vote> getAll() {
        return voteRepository.findAll();
    }

    @Override
    public List<Vote> getAllByRestaurantId(Integer id) {
        return voteRepository.getAllByRestaurantId(id);
    }
}
