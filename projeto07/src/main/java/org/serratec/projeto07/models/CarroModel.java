package org.serratec.projeto07.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "carro")
public class CarroModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "carro_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "dono_id", referencedColumnName = "cliente_id")
	private ClienteModel dono; 
	
	@Column(name = "marca")
	private String marca;
	
	@Column(name = "modelo")
	private String modelo;
	
	@Column(name = "ano")
	private String ano;

	public CarroModel() {}
	
	public CarroModel(ClienteModel dono, String marca, String modelo, String ano) {
		this.dono = dono;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
	}

	public ClienteModel getDono() {
		return dono;
	}

	public void setDono(ClienteModel dono) {
		this.dono = dono;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public Long getId() {
		return id;
	}
	
	
}
