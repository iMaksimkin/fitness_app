package com.simbirsoft.fitness.model.user;

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
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String surname;

    private String lastname;

    private LocalDateTime birthday;

    private String phone;

    private String password;

    @OneToMany(mappedBy = "coach", cascade = CascadeType.MERGE)
    private Set<Workout> workouts;
}
