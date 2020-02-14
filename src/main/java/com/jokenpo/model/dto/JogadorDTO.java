package com.jokenpo.model.dto;

import org.modelmapper.ModelMapper;

import com.jokenpo.model.Jogador;

import lombok.Data;

@Data
public class JogadorDTO {
	private String nome;
	private String opcaoJogada;
	private String OpcaoJogadorDois;
	private String resultado;

	public static JogadorDTO create(Jogador c) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(c, JogadorDTO.class);

	}

}