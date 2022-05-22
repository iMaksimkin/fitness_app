package com.simbirsoft.fitness.mapper;

import com.simbirsoft.fitness.model.Card;
import com.simbirsoft.fitness.model.dto.CardDTO;
import com.simbirsoft.fitness.model.dto.ClientDTO;
import com.simbirsoft.fitness.model.user.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CardMapper {

    @Mappings({
            @Mapping(target = "workoutAmount", source = "workoutAmount"),
            @Mapping(target = "lastVisitDay", source = "lastVisitDay")
    })
    CardDTO cardToCardDTO(Card entity);

    @Mappings({
            @Mapping(target = "workoutAmount", source = "workoutAmount"),
            @Mapping(target = "lastVisitDay", source = "lastVisitDay")

    })
    Card cardDTOToCard(CardDTO dto);
}
