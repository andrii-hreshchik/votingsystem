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
@RequestMapping(value = "ajax/meals")
public class MealAjaxController extends AbstractMealController {

    //TODO finish controller

//    @Override
//    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Meal> getAllByRestaurantId(@PathVariable("id") Integer id) throws NotFoundException {
//        return super.getAllByRestaurantId(id);
//    }

    @Override
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Meal get(@PathVariable("id") int id) throws NotFoundException {
        return super.get(id);
    }


    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Meal> getAll() {
        return super.getAll();
    }


    //TODO refactor to /today/restaurant/
    @Override
    @GetMapping(value = "/today/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Meal> getAllForTodayByRestaurantId(@PathVariable("id") Integer id) {
        return super.getAllForTodayByRestaurantId(id);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) throws NotFoundException {
        super.delete(id);
    }

    @PostMapping(value = "/{id}")
    public void createOrUpdate(@Validated(View.Web.class) Meal meal, @PathVariable("id") int restaurantId) {
        if (meal.isNew()) {
            super.create(meal);
        } else {
            super.update(meal, meal.getId(), restaurantId);
        }
    }
}
