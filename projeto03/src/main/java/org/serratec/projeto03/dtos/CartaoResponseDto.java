package org.serratec.projeto03.dtos;

import java.util.ArrayList;
import java.util.List;

import org.serratec.projeto03.models.OperacaoModel;

public class CartaoResponseDto {
	
	private Long cartaoId;
	private String numeroCartao;
	private Long contaBancariaId;
	private List<Long> listaOperacoesIds;
	
	public CartaoResponseDto(Long cartaoId, String numeroCartao, Long contaBancariaId, List<Long> listaOperacoesIds) {
		this.cartaoId = cartaoId;
		this.numeroCartao = numeroCartao;
		this.contaBancariaId = contaBancariaId;
		this.listaOperacoesIds = listaOperacoesIds;
	}
	
	public CartaoResponseDto() {
		
	}

	public Long getCartaoId() {
		return cartaoId;
	}

	public void setCartaoId(Long cartaoId) {
		this.cartaoId = cartaoId;
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

	public List<Long> getListaOperacoesIds() {
		return listaOperacoesIds;
	}

	public void setListaOperacoesIds(List<OperacaoModel> listaOperacoes) {
		
		List<Long> listaOperacoesIds = new ArrayList<Long>();
		
		for (OperacaoModel model : listaOperacoes) {
			listaOperacoesIds.add(model.getIdOperacao());
		}
		
		this.listaOperacoesIds = listaOperacoesIds;
	}
	
}
