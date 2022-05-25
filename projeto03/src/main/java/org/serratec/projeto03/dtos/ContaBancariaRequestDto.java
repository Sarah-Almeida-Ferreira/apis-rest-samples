package org.serratec.projeto03.dtos;

public class ContaBancariaRequestDto {
	
	private Long titularId;
	private double saldo;
	
	
	public ContaBancariaRequestDto() {
		
	}
	
	public ContaBancariaRequestDto(Long titularId, double saldo) {
		this.titularId = titularId;
		this.saldo = saldo;
	}

	public Long getTitularId() {
		return titularId;
	}

	public void setTitularId(Long titularId) {
		this.titularId = titularId;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}	
	
}
