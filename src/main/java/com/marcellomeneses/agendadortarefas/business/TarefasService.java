package com.marcellomeneses.agendadortarefas.business;

import com.marcellomeneses.agendadortarefas.Infrastructure.entity.TarefasEntity;
import com.marcellomeneses.agendadortarefas.Infrastructure.enums.StatusNotificacaoEnum;
import com.marcellomeneses.agendadortarefas.Infrastructure.repository.TarefasRepository;
import com.marcellomeneses.agendadortarefas.Infrastructure.security.JwtUtil;
import com.marcellomeneses.agendadortarefas.business.dto.TarefasDTO;
import com.marcellomeneses.agendadortarefas.business.mapper.TarefasConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefaConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa(String token ,TarefasDTO dto){
        String email = jwtUtil.extrairEmailToken(token.substring(7));
                dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        dto.setEmailUsuario(email);
        TarefasEntity entity =  tarefaConverter.paraTarefaEntity(dto);

        return tarefaConverter.paraTarefaDTO(
                tarefasRepository.save(entity));
    }

}
