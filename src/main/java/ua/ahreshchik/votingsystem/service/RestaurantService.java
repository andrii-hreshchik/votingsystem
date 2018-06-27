package ua.ahreshchik.votingsystem.service;

import ua.ahreshchik.votingsystem.model.Restaurant;
import ua.ahreshchik.votingsystem.util.exception.NotFoundException;

import java.util.List;

public interface RestaurantService {

    Restaurant create(Restaurant restaurant);

    Restaurant get(int id) throws NotFoundException;

    void update(Restaurant restaurant);

    void delete(int id) throws NotFoundException;

    List<Restaurant> getAll();

    Restaurant getWithVotes(int id);

    Restaurant getWithMeals(int id);
}
