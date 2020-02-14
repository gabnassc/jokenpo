package com.jokenpo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Jogador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	private String nome;
	
	@Column(name="idade")
	private int idade;
	
	@Column(name="opcaojogada")
	private String opcaoJogada;
	
	@Column(name = "opcaojogadordois")
	private String opcaoJogadorDois;
	
	@Column(name="resultado")
	private String resultado;
	
}
