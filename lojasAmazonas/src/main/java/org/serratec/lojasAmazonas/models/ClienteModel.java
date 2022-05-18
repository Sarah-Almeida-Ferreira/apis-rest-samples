package org.serratec.lojasAmazonas.models;

public class ClienteModel {
	
	private String id;
	private String cpf;
	private String senha;
	
	public ClienteModel(String id, String cpf, String senha) {
		this.id = id;
		this.cpf = cpf;
		this.senha = senha;
	}

	public String getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	

}
