package com.simbirsoft.fitness.service;

import com.simbirsoft.fitness.model.Workout;

import java.util.List;

public interface WorkoutService {
    List<Workout> getWorkouts();
    Workout getWorkout(Long id);
    Workout saveWorkout(Workout workout);
    Workout updateWorkout(Long id, Workout workout);
    void deleteWorkout(Long id);
}
