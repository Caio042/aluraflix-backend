package com.caiolima.AluraFlix.controller;

import java.util.List;

import com.caiolima.AluraFlix.dto.VideoDTO;
import com.caiolima.AluraFlix.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping ("/videos")
//talvez colocar CrossOrigin
public class VideoController {

	@Autowired
	private VideoService service;

	@GetMapping
	public ResponseEntity<List<VideoDTO>> buscarTodos(){
		return service.buscarTodos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<VideoDTO> buscarPorId(@PathVariable long id){
		return service.buscarPorId(id);
	}
}