package com.caiolima.AluraFlix.service;

import com.caiolima.AluraFlix.dto.VideoDTO;
import com.caiolima.AluraFlix.mapper.VideoMapper;
import com.caiolima.AluraFlix.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoService {

    @Autowired
    private VideoRepository repositorio;


    private final VideoMapper videoMapper = VideoMapper.INSTANCE;

    public ResponseEntity<List<VideoDTO>> buscarTodos(){

        return ResponseEntity.ok(repositorio.findAll()
                .stream().map(videoMapper::toDTO)
                .collect(Collectors.toList()));
    }

    public ResponseEntity<VideoDTO> buscarPorId(long id){

        return repositorio.findById(id)
                .map(resposta -> ResponseEntity.ok(videoMapper.toDTO(resposta)))
                .orElse(ResponseEntity.notFound().build());
    }



}
