package ua.ahreshchik.votingsystem.web.meal;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.ahreshchik.votingsystem.View;
import ua.ahreshchik.votingsystem.model.Meal;
import ua.ahreshchik.votingsystem.util.exception.NotFoundException;

import java.util.List;

@RestController
@RequestMapping(value = MealRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class MealRestController extends AbstractMealContoller {
    static final String REST_URL = "/meal";

    @Override
    @GetMapping("/{id}")
    public Meal get(@PathVariable("id") int id) throws NotFoundException {
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
    public List<Meal> getAll() {
        return super.getAll();
    }

    @Override
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@Validated(View.Web.class) @RequestBody Meal meal, @PathVariable("id") int id) {
        super.update(meal, id);
    }


}
