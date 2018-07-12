package ua.ahreshchik.votingsystem.web.meal;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.ahreshchik.votingsystem.model.Meal;
import ua.ahreshchik.votingsystem.util.exception.NotFoundException;

import java.util.List;

@RestController
@RequestMapping(value = "ajax/meals")
public class MealAjaxController extends AbstractMealController {

    @Override
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Meal> getAllByRestaurantId(@PathVariable("id") Integer id) throws NotFoundException {
        return super.getAllByRestaurantId(id);
    }

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Meal> getAll() {
        return super.getAll();
    }

    //TODO
//
//    @Override
//    public Meal create(Meal meal) {
//        return super.create(meal);
//    }
//
//    @Override
//    public Meal get(int id) throws NotFoundException {
//        return super.get(id);
//    }
//
//    @Override
//    public void update(Meal meal, int id) {
//        super.update(meal, id);
//    }
//
//    @Override
//    public void delete(int id) throws NotFoundException {
//        super.delete(id);
//    }
}
