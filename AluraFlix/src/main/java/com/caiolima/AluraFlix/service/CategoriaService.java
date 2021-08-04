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
    private CategoriaRepository repository;

    public ResponseEntity<List<CategoriaDTO>> buscarTodos() {
        return ResponseEntity.ok(repository.findAll()
                .stream().map(mapper::toDTO)
                .collect(Collectors.toList()));
    }

    public ResponseEntity<CategoriaDTO> buscarPorId(long id) {
        return repository.findById(id).map(categoria -> ResponseEntity.ok(mapper.toDTO(categoria)))
                .orElse(ResponseEntity.notFound().build());
    }


    public ResponseEntity<CategoriaDTO> criarCategoria(CategoriaDTO categoriaDTO) {

        Categoria categoria = mapper.toModel(categoriaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(repository.save(categoria)));
    }


    public ResponseEntity<CategoriaDTO> atualizar(CategoriaDTO categoriaDTO) {
        Categoria categoria = mapper.toModel(categoriaDTO);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTO(repository.save(categoria)));
    }


    public ResponseEntity<MensagemDTO> deletar(long id) {
        return repository.findById(id).map(categoria -> {
            repository.delete(categoria);
            return ResponseEntity.ok(MensagemDTO.builder()
                    .mensagem("Categoria de id " + id + " deletado com sucesso")
                    .build());})
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(MensagemDTO.builder()
                                .mensagem("Categoria de id " + id + " não encontrada")
                                .build()));
    }
}