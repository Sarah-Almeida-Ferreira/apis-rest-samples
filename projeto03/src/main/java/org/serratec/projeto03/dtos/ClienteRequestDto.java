package org.serratec.projeto03.dtos;

public class ClienteRequestDto {
	
	private String nome;
	private String cpf;
	
	public ClienteRequestDto() {
	}

	public ClienteRequestDto(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

}
