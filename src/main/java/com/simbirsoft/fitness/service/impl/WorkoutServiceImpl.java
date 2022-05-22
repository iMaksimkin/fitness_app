package com.simbirsoft.fitness.service.impl;

import com.simbirsoft.fitness.model.Workout;
import com.simbirsoft.fitness.repository.WorkoutRepository;
import com.simbirsoft.fitness.service.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutServiceImpl implements WorkoutService {
    private final WorkoutRepository workoutRepository;

    @Override
    public List<Workout> getWorkouts() {
        return workoutRepository.findAll();
    }

    @Override
    public Workout getWorkout(Long id) {
        return workoutRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Workout saveWorkout(Workout workout) {
        return workoutRepository.save(
                Workout.builder()
                        .coach(workout.getCoach())
                        .date(workout.getDate())
                        .title(workout.getTitle())
                        .clients(workout.getClients())
                        .build()
        );
    }

    @Override
    public Workout updateWorkout(Long id, Workout workout) {
        Workout currentWorkout = getWorkout(id);
        currentWorkout.setTitle(workout.getTitle());
        currentWorkout.setDate(workout.getDate());
        currentWorkout.setCoach(workout.getCoach());
        currentWorkout.setClients(workout.getClients());
        return workoutRepository.save(currentWorkout);
    }

    @Override
    public void deleteWorkout(Long id) {
        workoutRepository.deleteById(id);
    }
}
