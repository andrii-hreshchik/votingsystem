package ua.ahreshchik.votingsystem.model;

import org.hibernate.annotations.Formula;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "restaurants", uniqueConstraints = {@UniqueConstraint(columnNames = "title", name = "restaurant_unique_title_index")})
public class Restaurant extends AbstractBaseEntity {


    @Column(name = "title", nullable = false, unique = true)
    @NotBlank
    @Size(min = 5, max = 50)
    private String title;

    @Column(name = "description", nullable = false)
    @NotBlank
    @Size(min = 5)
    private String description;


    @Formula("(SELECT COUNT(v.id) FROM votes v WHERE v.date_time>=CURRENT_DATE AND v.restaurant_id=id)")
    private Integer todayRating;

    @Formula("(SELECT COUNT(v.id) FROM votes v WHERE v.restaurant_id=id)")
    private Integer overallRating;

    @Formula("(SELECT SUM(m.price) FROM meals m WHERE m.date_time>=CURRENT_DATE AND m.restaurant_id=id)")
    private Integer todayMenuPrice;


    @Column(name = "date_time", nullable = false)
    //    @DateTimeFormat(pattern = DateTimeUtil.DATE_TIME_PATTERN)
    private Date date = new Date();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    @OrderBy("description DESC")
    protected List<Meal> meals;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    @OrderBy("date DESC")
    protected List<Vote> votes;


    public Restaurant() {


    }

    public Restaurant(String title, String description, Date date) {
        this(null, title, description, date);
    }

    public Restaurant(Integer id, String title, String description, Date date) {
        super(id);
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date dateTime) {
        this.date = dateTime;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public List<Vote> getVotes() {
        return votes;
    }


    public Integer getTodayRating() {
        return todayRating;
    }

    public void setTodayRating(Integer todayRating) {
        this.todayRating = todayRating;
    }

    public Integer getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(Integer overallRating) {
        this.overallRating = overallRating;
    }

    public Integer getTodayMenuPrice() {
        return todayMenuPrice;
    }

    public void setTodayMenuPrice(Integer todayMenuPrice) {
        this.todayMenuPrice = todayMenuPrice;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dateTime=" + date +
                ", meals=" + meals +
                ", votes=" + votes +
                '}';
    }
}


