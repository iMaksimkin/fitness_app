package com.simbirsoft.fitness.model.user;

import com.simbirsoft.fitness.model.Card;
import com.simbirsoft.fitness.model.enums.ClientStatus;
import com.simbirsoft.fitness.model.Workout;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String surname;

    private String lastname;

    private LocalDateTime birthday;

    private String phone;

    private String password;

    private ClientStatus status;

    @OneToOne(
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private Card card;

    @ManyToMany( cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "client_workouts",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns= @JoinColumn(name = "workout_id"))
    private Set<Workout> workouts;
}
