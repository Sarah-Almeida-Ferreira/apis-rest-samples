package org.serratec.projeto07.dtos;

public class CarroDtoComIdCliente {
	
	private Long donoId; 
	private String marca;
	private String modelo;
	private String ano;
	
	public CarroDtoComIdCliente() {}
	
	public CarroDtoComIdCliente(Long donoId, String marca, String modelo, String ano) {
		this.donoId = donoId;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
	}

	public Long getDonoId() {
		return donoId;
	}

	public void setDonoId(Long donoId) {
		this.donoId = donoId;
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
