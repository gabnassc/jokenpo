package com.jokenpo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jokenpo.model.Jogador;
import com.jokenpo.model.dto.JogadorDTO;
import com.jokenpo.service.JogadorService;

@RestController
@RequestMapping("/api/v1/jokenpo")
public class JogadorController {
	
	@Autowired
	JogadorService service;

	@GetMapping()
	public ResponseEntity<List<JogadorDTO>> getTodasJogadas() {

		return ResponseEntity.ok(service.getJogadas());

		// mesmo retorno
		// return new ResponseEntity<>(service.getCarros(),HttpStatus.OK);
	}

	
	@PostMapping
	public ResponseEntity<JogadorDTO> post(@RequestBody Jogador jogador) {
		JogadorDTO c = service.insert(jogador);
		
			return  ResponseEntity.ok(c);
	}


	

}
