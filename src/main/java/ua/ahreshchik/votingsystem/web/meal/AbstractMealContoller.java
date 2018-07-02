package ua.ahreshchik.votingsystem.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ua.ahreshchik.votingsystem.model.Meal;
import ua.ahreshchik.votingsystem.service.MealService;
import ua.ahreshchik.votingsystem.util.exception.NotFoundException;

import java.util.List;

public abstract class AbstractMealContoller {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    MealService mealService;

    public Meal create(Meal meal) {
        log.info("create {}", meal);
        return mealService.create(meal);
    }

    public Meal get(int id) throws NotFoundException {
        log.info("get meal with id = {}", id);
        return mealService.get(id);
    }

    //TODO with id
    public void update(Meal meal, int id) {
        log.info("update {}", meal);
        mealService.update(meal);
    }

    public void delete(int id) throws NotFoundException {
        log.info("delete meal with id = {}");
        mealService.delete(id);
    }

    public List<Meal> getAll() {
        log.info("get all meals");
        return mealService.getAll();
    }
}
