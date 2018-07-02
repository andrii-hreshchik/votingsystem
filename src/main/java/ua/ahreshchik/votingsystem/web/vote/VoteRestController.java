package ua.ahreshchik.votingsystem.web.vote;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.ahreshchik.votingsystem.View;
import ua.ahreshchik.votingsystem.model.Vote;
import ua.ahreshchik.votingsystem.util.exception.NotFoundException;

import java.util.List;

@RestController
@RequestMapping(value = VoteRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteRestController extends AbstractVoteController {
    static final String REST_URL = "/vote";

    @Override
    @GetMapping("/{id}")
    public Vote get(@PathVariable("id") int id) throws NotFoundException {
        return super.get(id);
    }


    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) throws NotFoundException {
        super.delete(id);
    }


    @Override
    @GetMapping
    public List<Vote> getAll() {
        return super.getAll();
    }

    @Override
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@Validated(View.Web.class) @RequestBody Vote vote, @PathVariable("id") int id) {
        super.update(vote, id);
    }

}
