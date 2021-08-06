package com.caiolima.AluraFlix.service;

import com.caiolima.AluraFlix.dto.CategoriaDTO;
import com.caiolima.AluraFlix.dto.MensagemDTO;
import com.caiolima.AluraFlix.mapper.CategoriaMapper;
import com.caiolima.AluraFlix.model.Categoria;
import com.caiolima.AluraFlix.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    private final CategoriaMapper mapper = CategoriaMapper.INSTANCE;

    @Autowired
    private CategoriaRepository repositorio;

    public ResponseEntity<List<CategoriaDTO>> buscarTodos() {
        return ResponseEntity.ok(repositorio.findAll()
                .stream().map(mapper::toDTO)
                .collect(Collectors.toList()));
    }

    public ResponseEntity<CategoriaDTO> buscarPorId(Long id) {
        return repositorio.findById(id).map(categoria -> ResponseEntity.ok(mapper.toDTO(categoria)))
                .orElse(ResponseEntity.notFound().build());
    }


    public ResponseEntity<CategoriaDTO> criarCategoria(CategoriaDTO categoriaDTO) {

        Categoria categoria = repositorio.save(mapper.toModel(categoriaDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(categoria));
    }


    public ResponseEntity<CategoriaDTO> atualizar(CategoriaDTO categoriaDTO) {
        Categoria categoria = repositorio.save(mapper.toModel(categoriaDTO));
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTO(categoria));
    }


    public ResponseEntity<MensagemDTO> deletar(Long id) {
        return repositorio.findById(id).map(categoria -> {
            repositorio.delete(categoria);
            return ResponseEntity.ok(MensagemDTO.builder()
                    .mensagem("Categoria de id " + id + " deletado com sucesso")
                    .build());})

                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(MensagemDTO.builder()
                                .mensagem("Categoria de id " + id + " não encontrada")
                                .build()));
    }
}