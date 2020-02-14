package com.jokenpo.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.jokenpo.model.Jogador;
import com.jokenpo.model.dto.JogadorDTO;
import com.jokenpo.repository.JogadorRepository;

@Service
public class JogadorService {
	@Autowired
	private JogadorRepository rep;

	public JogadorDTO insert(Jogador jogador) {
		Assert.isNull(jogador.getId(), "Nao foi possivel inserir o registro.");

		jogador.setOpcaoJogadorDois(selecionarJogadaPc(jogador));

		if (jogador.getOpcaoJogada() == jogador.getOpcaoJogadorDois()) {
			jogador.setResultado("empate");

		} else if (jogador.getOpcaoJogada() == "pedra" && jogador.getOpcaoJogadorDois() == "tesoura") {
			jogador.setResultado("ganhou");
		} else if (jogador.getOpcaoJogada() == "papel" && jogador.getOpcaoJogadorDois() == "pedra") {
			jogador.setResultado("ganhou");
		} else if (jogador.getOpcaoJogada() == "tesoura" && jogador.getOpcaoJogadorDois() == "papel") {
			jogador.setResultado("ganhou");
		} else if (jogador.getOpcaoJogada() == "pedra" && jogador.getOpcaoJogadorDois() == "papel") {
			jogador.setResultado("perdeu");
		} else if (jogador.getOpcaoJogada() == "papel" && jogador.getOpcaoJogadorDois() == "tesoura") {
			jogador.setResultado("perdeu");
		} else {
			jogador.setResultado("perdeu");
		}

		return JogadorDTO.create(rep.save(jogador));
	}

	public List<JogadorDTO> getJogadas() {
		List<Jogador> jogadores = rep.findAll();
		List<JogadorDTO> list = jogadores.stream().map(c -> JogadorDTO.create(c)).collect(Collectors.toList());

		return list;
	}

	// metodo auxiliar para atribuir jogada da maquina
	private String selecionarJogadaPc(Jogador jogador) {
		Random random = new Random();
		int numeroAleatorio = random.nextInt(3);

		if (numeroAleatorio == 0) {
			return "pedra";
		} else if (numeroAleatorio == 1) {
			return "papel";
		} else {
			return "tesoura";
		}
		
	}

}
