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
@Table(name="Cartao")
public class CartaoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cartao_id")
	private Long cartaoId;
	
	@Column(name = "cartao_numero_cartao")
	private String numeroCartao;
	
	@ManyToOne
	@JoinColumn(name="cartao_conta_cartao")
	private ContaBancariaModel contaBancaria;
	
	@OneToMany(mappedBy = "cartao")
	@Column(name="cartao_lista_operacoes")
	private List<OperacaoModel> listaOperacoes;

	public CartaoModel(String numeroCartao, ContaBancariaModel contaBancaria) {
		this.numeroCartao = numeroCartao;
		this.contaBancaria = contaBancaria;
	}
	
	public CartaoModel() {

	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public ContaBancariaModel getContaBancaria() {
		return contaBancaria;
	}

	public void setContaBancaria(ContaBancariaModel contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	public List<OperacaoModel> getListaOperacoes() {
		return listaOperacoes;
	}

	public void setListaOperacoes(List<OperacaoModel> listaOperacoes) {
		this.listaOperacoes = listaOperacoes;
	}

	public Long getCartaoId() {
		return cartaoId;
	}	
	
}
