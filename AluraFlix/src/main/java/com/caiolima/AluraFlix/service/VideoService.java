package com.caiolima.AluraFlix.service;

import com.caiolima.AluraFlix.dto.CategoriaDTO;
import com.caiolima.AluraFlix.dto.MensagemDTO;
import com.caiolima.AluraFlix.dto.VideoDTO;
import com.caiolima.AluraFlix.mapper.VideoMapper;
import com.caiolima.AluraFlix.model.Video;
import com.caiolima.AluraFlix.repository.CategoriaRepository;
import com.caiolima.AluraFlix.repository.VideoRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoService {

    @Autowired
    private VideoRepository repositorio;

    @Autowired
    private CategoriaRepository categoria;

    private final VideoMapper mapper = VideoMapper.INSTANCE;

    public ResponseEntity<List<VideoDTO>> buscarTodos(){

        return ResponseEntity.ok(repositorio.findAll()
                .stream().map(mapper::toDTO)
                .collect(Collectors.toList()));
    }

    public ResponseEntity<VideoDTO> buscarPorId(Long id){

        return repositorio.findById(id)
                .map(resposta -> ResponseEntity.ok(mapper.toDTO(resposta)))
                .orElse(ResponseEntity.notFound().build());
    }


    public ResponseEntity<VideoDTO> publicar(VideoDTO videoDTO) {
        Video video = mapper.toModel(videoDTO);
        if (videoDTO.getCategoriaId() == null && categoria.findById(CategoriaDTO.builder().build().getCategoriaDefault()).isPresent()){
            video.setCategoria(categoria.findById(CategoriaDTO.builder().build().getCategoriaDefault()).get());
        } else if (categoria.findById(videoDTO.getCategoriaId()).isPresent()){
            video.setCategoria(categoria.findById(videoDTO.getCategoriaId()).get());
        } else{
            return ResponseEntity.notFound().build();
        }
        // TODO refatorar

        video = repositorio.save(video);
        videoDTO = mapper.toDTO(video);
        videoDTO.setCategoriaId(video.getCategoria().getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(videoDTO);
    }

    public ResponseEntity<MensagemDTO> deletar(Long id) {
        return repositorio.findById(id).map(video -> {
                    repositorio.delete(video);
                    return ResponseEntity.ok(MensagemDTO.builder()
                            .mensagem("Video de id " + id + " deletado com sucesso")
                            .build());
                }
            ).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(MensagemDTO
                .builder().mensagem("Video de id " + id + " não encontrado")
                .build()));
    }


    public ResponseEntity<VideoDTO> atualizar(VideoDTO videoDTO) {

        Video video = mapper.toModel(videoDTO);
        if (videoDTO.getCategoriaId() == null && categoria.findById(CategoriaDTO.builder().build().getCategoriaDefault()).isPresent()){
            video.setCategoria(categoria.findById(CategoriaDTO.builder().build().getCategoriaDefault()).get());
        } else if (categoria.findById(videoDTO.getCategoriaId()).isPresent()){
            video.setCategoria(categoria.findById(videoDTO.getCategoriaId()).get());
        } else{
            return ResponseEntity.notFound().build();
        }
        // TODO refatorar

        video = repositorio.save(video);
        videoDTO = mapper.toDTO(video);
        videoDTO.setCategoriaId(video.getCategoria().getId());
        return ResponseEntity.ok(videoDTO);
    }
}