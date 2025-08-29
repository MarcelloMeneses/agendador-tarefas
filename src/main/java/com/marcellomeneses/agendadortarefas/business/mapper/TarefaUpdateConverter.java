package com.marcellomeneses.agendadortarefas.business.mapper;

import com.marcellomeneses.agendadortarefas.Infrastructure.entity.TarefasEntity;
import com.marcellomeneses.agendadortarefas.business.dto.TarefasDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TarefaUpdateConverter {

    void updateTarefas(TarefasDTO dto, @MappingTarget TarefasEntity entity);
}
