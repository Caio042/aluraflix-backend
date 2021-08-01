package com.caiolima.AluraFlix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caiolima.AluraFlix.model.Videos;
import com.caiolima.AluraFlix.repository.VideosRepository;

@RestController
@RequestMapping ("/videos")
//talvez colocar CrossOrigin
public class VideosController {
	
	@Autowired
	private VideosRepository repositorio;
	
	@GetMapping
	public ResponseEntity<List<Videos>> buscarTodos(){
		return ResponseEntity.ok(repositorio.findAll());
	}
	
	@GetMapping("/{id")
	public ResponseEntity<Videos> buscarVideoPeloId(@PathVariable long id){
		return repositorio.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
}