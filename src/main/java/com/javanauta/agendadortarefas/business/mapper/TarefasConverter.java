package com.javanauta.agendadortarefas.business.mapper;

import com.javanauta.agendadortarefas.business.dto.TarefasDTORecord;
import com.javanauta.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    @Mapping( source = "id",target = "id")
    @Mapping(source = "dataEvento",target = "dataEvento")
    @Mapping(source = "dataCriacao", target = "dataCriacao")
    TarefasEntity paraTarefaEntity(TarefasDTORecord dto);

    TarefasDTORecord paraTarefaDTO(TarefasEntity entity);

    List<TarefasEntity> paraListaTarefaEntity(List<TarefasDTORecord> dto);

    List<TarefasDTORecord> paraListaTarefaDTO(List<TarefasEntity> entities);
}
