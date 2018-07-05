package ua.ahreshchik.votingsystem.web.restaurant;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.ahreshchik.votingsystem.model.Restaurant;
import ua.ahreshchik.votingsystem.util.exception.NotFoundException;

import java.util.List;

@RestController
@RequestMapping(value = "ajax/restaurants")
public class RestaurantAjaxController extends AbstractRestaurantController {

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Restaurant> getAll() {
        return super.getAll();
    }

    @Override
    @GetMapping(value = "/{id}")
    public Restaurant get(@PathVariable("id") int id) throws NotFoundException {
        return super.get(id);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) throws NotFoundException {
        super.delete(id);
    }

    @PostMapping
    public void createOrUpdate(Restaurant restaurant) {
        if (restaurant.isNew()) {
            super.create(restaurant);
        } else {
            super.update(restaurant, restaurant.getId());
        }
    }

}
