package ua.ahreshchik.votingsystem.model;

import org.springframework.format.annotation.DateTimeFormat;
import ua.ahreshchik.votingsystem.util.DateTimeUtil;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
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


    @Column(name = "date_time", nullable = false)
    @NotNull
    @DateTimeFormat(pattern = DateTimeUtil.DATE_TIME_PATTERN)
    private LocalDateTime dateTime;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    @OrderBy("description DESC")
    protected List<Meal> meals;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    @OrderBy("dateTime DESC")
    protected List<Vote> votes;

    public Restaurant() {
    }

    public Restaurant(String title, String description, LocalDateTime dateTime) {
        this(null, title, description, dateTime);
    }

    public Restaurant(Integer id, String title, String description, LocalDateTime dateTime) {
        super(id);
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dateTime=" + dateTime +
                ", meals=" + meals +
                ", votes=" + votes +

                '}';
    }
}


