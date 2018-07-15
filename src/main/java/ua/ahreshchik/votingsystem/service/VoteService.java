package ua.ahreshchik.votingsystem.service;


import org.springframework.data.jpa.repository.Query;
import ua.ahreshchik.votingsystem.model.Vote;
import ua.ahreshchik.votingsystem.util.exception.NotFoundException;

import java.util.List;

public interface VoteService {

    Vote create(Vote vote);

    Vote get(int id) throws NotFoundException;

    void update(Vote vote);

    void delete(int id) throws NotFoundException;

    //get by date?
    List<Vote> getAll();

    Integer getRatingForTodayByRestaurantId(Integer id);

    Integer getRatingOverallByRestaurantId(Integer id);


}
