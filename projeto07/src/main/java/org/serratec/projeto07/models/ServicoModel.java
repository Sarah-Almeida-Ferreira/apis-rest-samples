package org.serratec.projeto07.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "servico")
public class ServicoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "servico_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "carro_id", referencedColumnName = "carro_id")
	private CarroModel carro;
	
	@Column(name = "data")
	private LocalDate data;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "valor")
	private Double valor;

	public ServicoModel() {}
	
	public ServicoModel(CarroModel carro, LocalDate data, String descricao, Double valor) {
		this.carro = carro;
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
	}

	public CarroModel getCarro() {
		return carro;
	}

	public void setCarro(CarroModel carro) {
		this.carro = carro;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}
		
}
