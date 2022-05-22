package com.simbirsoft.fitness.service.impl;

import com.simbirsoft.fitness.mapper.UserMapper;
import com.simbirsoft.fitness.model.dto.CoachDTO;
import com.simbirsoft.fitness.model.user.Client;
import com.simbirsoft.fitness.model.user.Coach;
import com.simbirsoft.fitness.repository.CoachRepository;
import com.simbirsoft.fitness.service.CoachService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoachServiceImpl implements CoachService {
    private final CoachRepository coachRepository;
    private final UserMapper userMapper;

    @Override
    public List<Coach> getCoaches() {
        return coachRepository.findAll();
    }

    @Override
    public Coach getCoach(Long id) {
        return coachRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Coach saveCoach(CoachDTO coachDTO) {
        return coachRepository.save(userMapper.coachDTOToCoach(coachDTO));
    }

    @Override
    public Coach updateCoach(Long id, CoachDTO coachDTO) {
        Coach coach = userMapper.coachDTOToCoach(coachDTO);
        coach.setId(id);
        return coachRepository.save(coach);
    }

    @Override
    public void deleteCoach(Long id) {
        coachRepository.deleteById(id);
    }
}
