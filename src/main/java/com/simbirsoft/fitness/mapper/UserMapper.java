package com.simbirsoft.fitness.mapper;

import com.simbirsoft.fitness.model.Workout;
import com.simbirsoft.fitness.model.dto.ClientDTO;
import com.simbirsoft.fitness.model.dto.CoachDTO;
import com.simbirsoft.fitness.model.user.Client;
import com.simbirsoft.fitness.model.user.Coach;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mappings({
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "surname", source = "surname"),
            @Mapping(target = "lastname", source = "lastname"),
            @Mapping(target = "birthday", source = "birthday"),
            @Mapping(target = "phone", source = "phone"),
            @Mapping(target = "password", source = "password"),
            @Mapping(target = "status", source = "status"),
            @Mapping(target = "card", source = "card"),
            @Mapping(target = "workouts", source = "workouts", qualifiedByName = "workoutToId")
    })
    ClientDTO clientToClientDTO(Client entity);

    @Mappings({
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "surname", source = "surname"),
            @Mapping(target = "lastname", source = "lastname"),
            @Mapping(target = "birthday", source = "birthday"),
            @Mapping(target = "phone", source = "phone"),
            @Mapping(target = "password", source = "password"),
            @Mapping(target = "status", source = "status"),
            @Mapping(target = "card", source = "card"),
            @Mapping(target = "workouts", source = "workouts", qualifiedByName = "idToWorkout")

    })
    Client clientDTOToClient(ClientDTO dto);

    @Mappings({
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "surname", source = "surname"),
            @Mapping(target = "lastname", source = "lastname"),
            @Mapping(target = "birthday", source = "birthday"),
            @Mapping(target = "phone", source = "phone"),
            @Mapping(target = "password", source = "password"),
            @Mapping(target = "workouts", source = "workouts", qualifiedByName = "workoutToId")
    })
    CoachDTO coachToCoachDTO(Coach entity);

    @Mappings({
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "surname", source = "surname"),
            @Mapping(target = "lastname", source = "lastname"),
            @Mapping(target = "birthday", source = "birthday"),
            @Mapping(target = "phone", source = "phone"),
            @Mapping(target = "password", source = "password"),
            @Mapping(target = "workouts", source = "workouts", qualifiedByName = "idToWorkout")

    })
    Coach coachDTOToCoach(CoachDTO dto);

    @Named("workoutToId")
    public static Long workoutToId(Workout entity) {
        return entity.getId();
    }

    @Named("idToWorkout")
    public static Workout idToWorkout(Long id) {
        return new Workout(id);
    }
}
