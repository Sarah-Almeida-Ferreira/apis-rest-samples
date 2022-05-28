package org.serratec.projeto03.dtos;

public class OperacaoRequestDto {
	
	private Double valorOperacao;
	private Long cartaoId;

	public OperacaoRequestDto() {
	
	}
	
	public OperacaoRequestDto(Double valorOperacao, Long cartaoId) {
		this.valorOperacao = valorOperacao;
		this.cartaoId = cartaoId;
	}

	public Double getValorOperacao() {
		return valorOperacao;
	}

	public void setValorOperacao(Double valorOperacao) {
		this.valorOperacao = valorOperacao;
	}

	public Long getCartaoId() {
		return cartaoId;
	}

	public void setCartaoId(Long cartaoId) {
		this.cartaoId = cartaoId;
	}

}
