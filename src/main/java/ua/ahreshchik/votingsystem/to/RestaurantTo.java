package ua.ahreshchik.votingsystem.to;


import org.hibernate.validator.constraints.SafeHtml;
import ua.ahreshchik.votingsystem.model.Meal;
import ua.ahreshchik.votingsystem.model.Vote;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

public class RestaurantTo extends BaseTo implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank
    @Size(min = 5, max = 50)
    @SafeHtml
    private String title;

    @NotBlank
    @Size(min = 5)
    @SafeHtml
    private String description;

    @NotNull
    private List<Meal> meals;

    @NotNull
    private List<Vote> votes;

    @NotNull
    private Integer rating;

    @NotNull
    private Integer menuPrice;

    public RestaurantTo() {
    }

    public RestaurantTo(Integer id, String title, String description, Integer rating, Integer menuPrice, List<Meal> meals, List<Vote> votes) {
        super(id);
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.meals = meals;
        this.votes = votes;
        this.menuPrice = menuPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(Integer menuPrice) {
        this.menuPrice = menuPrice;
    }
}
