package org.serratec.projeto03.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.serratec.projeto03.enums.TipoOperacao;

@Entity
@Table(name="operacao")
public class OperacaoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "operacao_id")
	private Long idOperacao;
	
	@Column(name = "tipo_operacao")
	private TipoOperacao tipoOperacao;
	
	@Column(name = "data_operacao") 
	private LocalDate dataOperacao;
	
	@Column(name = "valor_operacao")
	private Double valorOperacao;
	
	@ManyToOne
	@JoinColumn(name = "operacao_cartao_id")
	private CartaoModel cartao;

	public OperacaoModel() {
	
	}
	
	public OperacaoModel(TipoOperacao tipoOperacao, Double valorOperacao, CartaoModel cartao) {
		this.tipoOperacao = tipoOperacao;
		this.valorOperacao = valorOperacao;
		this.cartao = cartao;
	}

	public TipoOperacao getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(TipoOperacao tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public Double getValorOperacao() {
		return valorOperacao;
	}

	public void setValorOperacao(Double valorOperacao) {
		this.valorOperacao = valorOperacao;
	}

	public CartaoModel getCartao() {
		return cartao;
	}

	public void setCartao(CartaoModel cartao) {
		this.cartao = cartao;
	}

	public Long getIdOperacao() {
		return idOperacao;
	}

	public LocalDate getDataOperacao() {
		return dataOperacao;
	}

	public void setDataOperacao(LocalDate dataOperacao) {
		this.dataOperacao = dataOperacao;
	}	
	
	
	
}
