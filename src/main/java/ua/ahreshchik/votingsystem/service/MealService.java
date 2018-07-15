package ua.ahreshchik.votingsystem.service;

import org.springframework.data.repository.query.Param;
import ua.ahreshchik.votingsystem.model.Meal;
import ua.ahreshchik.votingsystem.util.exception.NotFoundException;

import java.util.List;

public interface MealService {


    Meal create(Meal meal);

    Meal get(int id) throws NotFoundException;

    void update(Meal meal);

    void delete(int id) throws NotFoundException;

    List<Meal> getAll();

    List<Meal> getAllByRestaurantId(Integer id);

    List<Meal> getAllForTodayByRestaurantId(Integer id);

    Integer getMealsPriceForTodayByRestaurantId(Integer id);
}
