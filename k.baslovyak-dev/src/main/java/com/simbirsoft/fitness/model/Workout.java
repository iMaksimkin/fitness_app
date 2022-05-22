package com.simbirsoft.fitness.model;

import com.simbirsoft.fitness.model.user.Client;
import com.simbirsoft.fitness.model.user.Coach;
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
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne()
    @JoinColumn(name = "coach_id")
    private Coach coach;

    private String title;

    private LocalDateTime date;

    @ManyToMany(mappedBy = "workouts")
    private Set<Client> clients;

    public Workout(long id) {
        this.id = id;
    }
}
