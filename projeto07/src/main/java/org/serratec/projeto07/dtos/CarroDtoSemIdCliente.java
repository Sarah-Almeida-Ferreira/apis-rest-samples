package org.serratec.projeto07.dtos;

public class CarroDtoSemIdCliente {
	
	private String marca;
	private String modelo;
	private String ano;
	
	public CarroDtoSemIdCliente() {}
	
	public CarroDtoSemIdCliente(String marca, String modelo, String ano) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
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

}
