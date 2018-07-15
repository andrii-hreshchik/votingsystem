package ua.ahreshchik.votingsystem.to;


import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


//TODO Redundant

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
    private Integer ratingToday;

    @NotNull
    private Integer ratingOverall;

    @NotNull
    private Integer todayMenuPrice;

    public RestaurantTo() {
    }

    public RestaurantTo(Integer id, String title, String description, Integer ratingToday, Integer ratingOverall, Integer todayMenuPrice) {
        super(id);
        this.title = title;
        this.description = description;
        this.ratingToday = ratingToday;
        this.ratingOverall = ratingOverall;
        this.todayMenuPrice = todayMenuPrice;
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

    public Integer getRatingToday() {
        return ratingToday;
    }

    public void setRatingToday(Integer ratingToday) {
        this.ratingToday = ratingToday;
    }

    public Integer getTodayMenuPrice() {
        return todayMenuPrice;
    }

    public void setTodayMenuPrice(Integer todayMenuPrice) {
        this.todayMenuPrice = todayMenuPrice;
    }

    public Integer getRatingOverall() {
        return ratingOverall;
    }

    public void setRatingOverall(Integer ratingOverall) {
        this.ratingOverall = ratingOverall;
    }
}
