package org.serratec.projeto03.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class ClienteModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cliente_id")
	private Long id;
	
	@Column(name = "cliente_nome")
	private String nome;
	
	@Column(name="cliente_cpf", unique=true)
	private String cpf;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "titular")
	@Column(name = "conta_bancaria_id")
	private List<ContaBancariaModel> contasBancarias;
	
	public ClienteModel() {
	}

	public ClienteModel(Long id, String nome, String cpf) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
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

	public List<ContaBancariaModel> getContasBancarias() {
		return contasBancarias;
	}

	public void setContasBancarias(List<ContaBancariaModel> contasBancarias) {
		this.contasBancarias = contasBancarias;
	}

	public Long getId() {
		return id;
	}
	
}
