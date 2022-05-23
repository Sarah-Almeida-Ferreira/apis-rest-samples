package org.serratec.projeto03.dtos;

public class ContaBancariaDto {
	
	private Long titularId;
	private double saldo;
	
	public ContaBancariaDto() {
	}
	
	public ContaBancariaDto(Long titularId, double saldo) {
		this.titularId = titularId;
		this.saldo = saldo;
	}

	public Long getTitularId() {
		return titularId;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
