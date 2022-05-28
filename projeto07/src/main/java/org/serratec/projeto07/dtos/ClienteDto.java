package org.serratec.projeto07.dtos;

import java.util.List;

public class ClienteDto {
	
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private List<CarroDtoSemIdCliente> carros;
	
	public ClienteDto() {}

	public ClienteDto(String nome, String cpf, String telefone, String email, List<CarroDtoSemIdCliente> carros) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.carros = carros;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<CarroDtoSemIdCliente> getCarros() {
		return carros;
	}

	public void setCarros(List<CarroDtoSemIdCliente> carros) {
		this.carros = carros;
	}
	
}
