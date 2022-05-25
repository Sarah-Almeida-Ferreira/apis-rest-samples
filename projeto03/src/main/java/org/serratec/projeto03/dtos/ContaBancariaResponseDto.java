package org.serratec.projeto03.dtos;

public class ContaBancariaResponseDto {
	
	private Long contaBancariaId;
	private Long titularId;
	private double saldo;
	
	public ContaBancariaResponseDto() {
		
	}
	
	public ContaBancariaResponseDto(Long contaBancariaId, Long titularId, double saldo) {
		this.contaBancariaId = contaBancariaId;
		this.titularId = titularId;
		this.saldo = saldo;
	}

	public Long getContaBancariaId() {
		return contaBancariaId;
	}

	public void setContaBancariaId(Long contaBancariaId) {
		this.contaBancariaId = contaBancariaId;
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
