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
	private Long idCliente;
	
	@Column(name = "numero_conta", unique=true)
	private String numConta;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private ClienteModel cliente;
	
	@Column(name = "saldo_conta")
	private double saldo;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "contaBancaria")
	@Column(name = "operacoes_da_conta")
	private List<OperacaoModel> operacoes;
	
	public ContaBancariaModel() {
	}
	
	public ContaBancariaModel(Long id, String numConta, String cpfTitular, double saldo) {
		this.idCliente = id;
		this.numConta = numConta;
		this.saldo = saldo;
	}

	public ClienteModel getTitular() {
		return cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Long getId() {
		return idCliente;
	}

	public String getNumConta() {
		return numConta;
	}

	public List<OperacaoModel> getListaOperacoes() {
		return operacoes;
	}
	
}
