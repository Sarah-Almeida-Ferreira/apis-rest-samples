package org.serratec.projeto03.dtos;

public class OperacaoRequestDto {
	
	private Double valorOperacao;
	private Long contaBancariaId;

	public OperacaoRequestDto() {
	
	}
	
	public OperacaoRequestDto(Double valorOperacao, Long contaBancariaId) {
		this.valorOperacao = valorOperacao;
		this.contaBancariaId = contaBancariaId;
	}

	public Double getValorOperacao() {
		return valorOperacao;
	}

	public void setValorOperacao(Double valorOperacao) {
		this.valorOperacao = valorOperacao;
	}

	public Long getContaBancariaId() {
		return contaBancariaId;
	}

	public void setContaBancariaId(Long contaBancariaId) {
		this.contaBancariaId = contaBancariaId;
	}

}
