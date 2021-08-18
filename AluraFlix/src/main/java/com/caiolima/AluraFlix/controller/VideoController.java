package com.caiolima.AluraFlix.controller;

import java.util.List;
import java.util.Optional;

import com.caiolima.AluraFlix.dto.MensagemDTO;
import com.caiolima.AluraFlix.dto.VideoDTO;
import com.caiolima.AluraFlix.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping ("/videos")
//talvez colocar CrossOrigin
public class VideoController {

	@Autowired
	private VideoService service;

	@GetMapping
	public ResponseEntity<List<VideoDTO>> buscarTodos(@RequestParam (name = "search", required = false)
																  Optional<String> titulo){

		return titulo.map(titulolmb -> ResponseEntity.ok(service.buscarPorTitulo(titulolmb)))
				.orElse(ResponseEntity.ok(service.buscarTodos()));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<VideoDTO> buscarPorId(@PathVariable Long id){
		return service.buscarPorId(id);
	}

	@PostMapping
	public ResponseEntity<VideoDTO> publicar (@RequestBody @Valid VideoDTO videoDTO){
		return service.publicar(videoDTO);
	}

	@PutMapping
	public ResponseEntity<VideoDTO> atualizar (@RequestBody VideoDTO videoDTO){
		return service.atualizar(videoDTO);
	}

	@DeleteMapping ("/{id}")
	public ResponseEntity <MensagemDTO> deletar (@PathVariable Long id){
		return service.deletar(id);
	}
}