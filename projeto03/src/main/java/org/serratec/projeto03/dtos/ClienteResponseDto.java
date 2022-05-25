package org.serratec.projeto03.dtos;

import java.util.List;

public class ClienteResponseDto {
	
	private Long id;
	private String nome;
	private String cpf;
	private List<Long> contasBancariasIds;
	
	public ClienteResponseDto() {
	}

	public ClienteResponseDto(Long id, String nome, String cpf, List<Long> contasBancariasIds) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.contasBancariasIds = contasBancariasIds;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Long> getContasBancariasIds() {
		return contasBancariasIds;
	}

	public void setContasBancariasIds(List<Long> contasBancariasIds) {
		this.contasBancariasIds = contasBancariasIds;
	}
	
}
