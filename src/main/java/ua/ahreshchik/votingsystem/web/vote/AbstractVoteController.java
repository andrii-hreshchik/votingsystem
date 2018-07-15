package ua.ahreshchik.votingsystem.web.vote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ua.ahreshchik.votingsystem.model.Vote;
import ua.ahreshchik.votingsystem.service.VoteService;
import ua.ahreshchik.votingsystem.util.exception.NotFoundException;

import java.util.List;


public abstract class AbstractVoteController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private VoteService voteService;

    public Vote create(Vote vote) {
        log.info("create {}", vote);
        return voteService.create(vote);
    }

    public Vote get(int id) throws NotFoundException {
        log.info("ger vote with id = {}", id);
        return voteService.get(id);
    }


    //TODO with ID
    public void update(Vote vote, int id) {
        log.info("update {}", vote);
        voteService.update(vote);
    }

    public void delete(int id) throws NotFoundException {
        log.info("delete vote with id = {}", id);
        voteService.delete(id);
    }

    //get by restaurant?
    //get by date?
    public List<Vote> getAll() {
        log.info("get all votes");
        return voteService.getAll();
    }
}
