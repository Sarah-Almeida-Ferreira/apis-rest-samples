package org.serratec.projeto03.dtos;

public class ContaBancariaRequestDto {
	
	private Long titularId;
	private Double saldo;
	
	
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

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}	
	
}
