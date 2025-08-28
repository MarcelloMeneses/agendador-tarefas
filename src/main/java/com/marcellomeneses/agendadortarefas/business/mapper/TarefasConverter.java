package com.marcellomeneses.agendadortarefas.business.mapper;

import com.marcellomeneses.agendadortarefas.Infrastructure.entity.TarefasEntity;
import com.marcellomeneses.agendadortarefas.business.dto.TarefasDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    TarefasEntity paraTarefaEntity(TarefasDTO dto);

    TarefasDTO paraTarefaDTO(TarefasEntity entity);

}
