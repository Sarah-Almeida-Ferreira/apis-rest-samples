package org.serratec.projeto03.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="conta_bancaria")
public class ContaBancariaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="conta_bancaria_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "titular_id")
	private ClienteModel titular;
	
	@Column(name = "saldo_conta")
	private double saldo;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "contaBancaria")
	@Column(name = "operacoes_da_conta")
	private List<OperacaoModel> operacoes;

	public ContaBancariaModel() {
		
	}
	
	public ContaBancariaModel(Long id, ClienteModel titular, double saldo, List<OperacaoModel> operacoes) {
		this.id = id;
		this.titular = titular;
		this.saldo = saldo;
		this.operacoes = operacoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ClienteModel getTitular() {
		return titular;
	}

	public void setTitular(ClienteModel titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public List<OperacaoModel> getOperacoes() {
		return operacoes;
	}

	public void setOperacoes(List<OperacaoModel> operacoes) {
		this.operacoes = operacoes;
	}
	
	
}
