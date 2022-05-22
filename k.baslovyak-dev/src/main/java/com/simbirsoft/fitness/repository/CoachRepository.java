package com.simbirsoft.fitness.repository;

import com.simbirsoft.fitness.model.user.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {
}
