package com.atec.mapper;



import com.atec.dto.InterventionDTO;
import com.atec.model.Intervention;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface InterventionMapper {

    InterventionDTO toInterventionDTO(Intervention intervention);

    List<InterventionDTO> toInterventionDTOs(List<Intervention> interventions);

    Intervention toIntervention(InterventionDTO interventionDTO);

}
