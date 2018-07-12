package ua.ahreshchik.votingsystem.web.vote;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.ahreshchik.votingsystem.model.Vote;

import java.util.List;

@RestController
@RequestMapping("ajax/votes")
public class VoteAjaxController extends AbstractVoteController {

//    @Override
//    public Vote create(Vote vote) {
//        return super.create(vote);
//    }
//
//    @Override
//    public Vote get(int id) throws NotFoundException {
//        return super.get(id);
//    }
//
//    @Override
//    public void update(Vote vote, int id) {
//        super.update(vote, id);
//    }
//
//    @Override
//    public void delete(int id) throws NotFoundException {
//        super.delete(id);
//    }

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vote> getAll() {
        return super.getAll();
    }

    @Override
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vote> getAllByRestaurantId(@PathVariable("id") Integer id) {
        return super.getAllByRestaurantId(id);
    }
}
