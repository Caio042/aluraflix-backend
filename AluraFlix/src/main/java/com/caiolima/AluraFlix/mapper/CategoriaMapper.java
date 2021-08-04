package com.caiolima.AluraFlix.mapper;

import com.caiolima.AluraFlix.dto.CategoriaDTO;
import com.caiolima.AluraFlix.model.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoriaMapper {

    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    Categoria toModel (CategoriaDTO categoriaDTO);

    CategoriaDTO toDTO (Categoria categoria);
}
