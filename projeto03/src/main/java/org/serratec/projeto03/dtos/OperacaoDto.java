package org.serratec.projeto03.dtos;

import org.serratec.projeto03.enums.TipoOperacao;

public class OperacaoDto {
	
	private TipoOperacao tipoOperacao;
	private Double valorOperacao;
	private Long contaBancariaId;
	
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
	
	
}
