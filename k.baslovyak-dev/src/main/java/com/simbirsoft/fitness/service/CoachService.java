package com.simbirsoft.fitness.service;

import com.simbirsoft.fitness.model.dto.CoachDTO;
import com.simbirsoft.fitness.model.user.Coach;
import java.util.List;

public interface CoachService {
    List<Coach> getCoaches();
    Coach getCoach(Long id);
    Coach saveCoach(CoachDTO coachDTO);
    Coach updateCoach(Long id, CoachDTO coachDTO);
    void deleteCoach(Long id);
}
