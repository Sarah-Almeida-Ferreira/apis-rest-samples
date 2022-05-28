package org.serratec.projeto03.models;

import java.util.List;

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
	private Double saldo;
	
	@OneToMany(mappedBy = "contaBancaria")
	@Column(name = "conta_lista_cartao")
	private List<CartaoModel> cartoes;

	public ContaBancariaModel() {
		
	}
	
	public ContaBancariaModel(Long id, ClienteModel titular, double saldo, List<OperacaoModel> operacoes) {
		this.id = id;
		this.titular = titular;
		this.saldo = saldo;
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

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public List<CartaoModel> getCartoes() {
		return cartoes;
	}

	public void setCartoes(List<CartaoModel> cartoes) {
		this.cartoes = cartoes;
	}
	
	
}
