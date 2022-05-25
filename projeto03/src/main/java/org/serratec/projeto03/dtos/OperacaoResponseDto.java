package org.serratec.projeto03.dtos;

import java.time.LocalDate;

import org.serratec.projeto03.enums.TipoOperacao;

public class OperacaoResponseDto {
	
	private Long idOperacao;
	private TipoOperacao tipoOperacao;
	private LocalDate dataOperacao;
	private Double valorOperacao;
	private Long contaBancariaId;

	public OperacaoResponseDto() {
	
	}
	
	public OperacaoResponseDto(TipoOperacao tipoOperacao, Double valorOperacao, Long contaBancariaId) {
		this.tipoOperacao = tipoOperacao;
		this.valorOperacao = valorOperacao;
		this.contaBancariaId = contaBancariaId;
	}

	public TipoOperacao getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(TipoOperacao tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
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

	public Long getIdOperacao() {
		return idOperacao;
	}

	public LocalDate getDataOperacao() {
		return dataOperacao;
	}
	
	public void setDataOperacao(LocalDate dataOperacao) {
		this.dataOperacao = dataOperacao;
	}

	public void setIdOperacao(Long idOperacao) {
		this.idOperacao = idOperacao;
	}	
	
}
