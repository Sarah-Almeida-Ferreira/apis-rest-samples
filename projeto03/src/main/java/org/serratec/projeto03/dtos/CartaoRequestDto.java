package org.serratec.projeto03.dtos;

public class CartaoRequestDto {
	
	private String numeroCartao;
	private Long contaBancariaId;
	
	public CartaoRequestDto (String numeroCartao, Long contaBancariaId) {
		this.numeroCartao = numeroCartao;
		this.contaBancariaId = contaBancariaId;
	}
	
	public CartaoRequestDto() {
		
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public Long getContaBancariaId() {
		return contaBancariaId;
	}

	public void setContaBancariaId(Long contaBancariaId) {
		this.contaBancariaId = contaBancariaId;
	}
	
}
