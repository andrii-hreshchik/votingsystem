package ua.ahreshchik.votingsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ua.ahreshchik.votingsystem.model.Vote;
import ua.ahreshchik.votingsystem.repository.RestaurantRepository;
import ua.ahreshchik.votingsystem.repository.UserRepository;
import ua.ahreshchik.votingsystem.repository.VoteRepository;
import ua.ahreshchik.votingsystem.service.VoteService;
import ua.ahreshchik.votingsystem.util.exception.NotFoundException;

import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {

    private VoteRepository voteRepository;

    private RestaurantRepository restaurantRepository;

    private UserRepository userRepository;

    @Autowired
    public VoteServiceImpl(VoteRepository voteRepository, RestaurantRepository restaurantRepository, UserRepository userRepository) {
        this.voteRepository = voteRepository;
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Vote create(Vote vote, int restaurantId, int userId) {
        Assert.notNull(vote, "vote must not be null");
        if (voteRepository.getVotesCountForTodayByUserId(userId) == 0) {
            vote.setRestaurant(restaurantRepository.getOne(restaurantId));
            vote.setUser(userRepository.getOne(userId));
            return voteRepository.save(vote);
        } else return null;
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
    public Integer getRatingForTodayByRestaurantId(Integer id) {
        return voteRepository.getRatingForTodayByRestaurantId(id);
    }

    @Override
    public Integer getRatingOverallByRestaurantId(Integer id) {
        return voteRepository.getRatingOverallByRestaurantId(id);
    }
}
