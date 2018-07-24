package ua.ahreshchik.votingsystem.model;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "meals")
public class Meal extends AbstractBaseEntity {


    @Column(name = "date_time", columnDefinition = "TIMESTAMP DEFAULT now()")
    @NotNull
    private Date date = new Date();

    @Column(name = "price", nullable = false)
    @Range(min = 1)
    @NotNull
    private Integer price;


    @Column(name = "description", nullable = false)
    @Size(min = 3, max = 100)
    @NotBlank
    private String description;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Restaurant restaurant;


    public Meal() {
    }

    public Meal(Integer id, Integer price, String description, Date date) {
        super(id);
        this.price = price;
        this.description = description;
        this.date = date;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ".description='" + description + '\'' +
                ",price=" + price +
                ", restaurant=" + restaurant.getTitle() +
                ", date=" + date +
                '}';
    }
}
