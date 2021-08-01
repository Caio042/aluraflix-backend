package com.caiolima.AluraFlix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caiolima.AluraFlix.model.Video;
import com.caiolima.AluraFlix.repository.VideoRepository;

@RestController
@RequestMapping ("/videos")
//talvez colocar CrossOrigin
public class VideoController {
	
	@Autowired
	private VideoRepository repositorio;
	
	@GetMapping
	public ResponseEntity<List<Video>> buscarTodos(){
		return ResponseEntity.ok(repositorio.findAll());
	}
	
	@GetMapping("/{id")
	public ResponseEntity<Video> buscarVideoPeloId(@PathVariable long id){
		return repositorio.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
}