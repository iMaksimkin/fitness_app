package com.simbirsoft.fitness.model.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoachDTO {

    private String name;

    private String surname;

    private String lastname;

    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
    private LocalDateTime birthday;

    private String phone;

    private String password;

    private Set<Long> workouts;
}
