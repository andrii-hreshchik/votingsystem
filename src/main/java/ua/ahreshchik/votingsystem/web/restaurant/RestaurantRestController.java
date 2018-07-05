package ua.ahreshchik.votingsystem.web.restaurant;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.ahreshchik.votingsystem.View;
import ua.ahreshchik.votingsystem.model.Restaurant;
import ua.ahreshchik.votingsystem.util.exception.NotFoundException;

import java.util.List;


//@RestController
//@RequestMapping(value = RestaurantRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantRestController extends AbstractRestaurantController {
    static final String REST_URL = "/restaurants";

    @Override
    @GetMapping("/{id}")
    public Restaurant get(@PathVariable("id") int id) throws NotFoundException {
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
    public List<Restaurant> getAll() {
        return super.getAll();
    }


    @Override
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@Validated(View.Web.class) @RequestBody Restaurant restaurant, @PathVariable("id") int id) {
        super.update(restaurant, id);
    }

    //TODO other methods
}
