package ua.ahreshchik.votingsystem.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Entity
@Table(name = "votes")
public class Vote extends AbstractBaseEntity {


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    //todo notnull persist
    private User user;

    @Column(name = "date_time")
    @NotNull
    @DateTimeFormat
    private LocalDateTime localDateTime;
    private Restaurant restaurant;

}
