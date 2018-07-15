package ua.ahreshchik.votingsystem.util;


import ua.ahreshchik.votingsystem.model.Restaurant;
import ua.ahreshchik.votingsystem.to.RestaurantTo;

public class RestaurantUtil {

    public static RestaurantTo asTo(Restaurant restaurant, Integer todayMealsPrice, Integer todayVotes, Integer overallVotes) {

        return new RestaurantTo(restaurant.getId(), restaurant.getTitle(), restaurant.getDescription(), todayVotes, overallVotes, todayMealsPrice);
    }
}
