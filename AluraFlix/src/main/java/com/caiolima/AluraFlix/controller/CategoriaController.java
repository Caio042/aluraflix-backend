package com.caiolima.AluraFlix.controller;

import com.caiolima.AluraFlix.dto.CategoriaDTO;
import com.caiolima.AluraFlix.dto.MensagemDTO;
import com.caiolima.AluraFlix.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> buscarTodos(){
        return service.buscarTodos();
    }

    @GetMapping ("/{id}")
    public ResponseEntity<CategoriaDTO> buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> criarCategoria(@RequestBody @Valid CategoriaDTO categoriaDTO){
        return service.criarCategoria(categoriaDTO);
    }

    @PutMapping
    public ResponseEntity<CategoriaDTO> atualizar (@RequestBody @Valid CategoriaDTO categoriaDTO){
        return service.atualizar(categoriaDTO);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<MensagemDTO> deletar(@PathVariable Long id){
        return service.deletar(id);
    }
}