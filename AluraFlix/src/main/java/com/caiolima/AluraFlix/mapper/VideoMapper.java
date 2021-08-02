package com.caiolima.AluraFlix.mapper;

import com.caiolima.AluraFlix.dto.VideoDTO;
import com.caiolima.AluraFlix.model.Video;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VideoMapper {

    VideoMapper INSTANCE = Mappers.getMapper(VideoMapper.class);

    Video toModel(VideoDTO videoDTO);

    VideoDTO toDTO(Video video);
}
