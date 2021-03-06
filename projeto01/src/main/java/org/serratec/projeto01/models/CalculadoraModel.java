package org.serratec.projeto01.models;

import org.serratec.projeto01.enums.Operacao;

public class CalculadoraModel {
	
	private Operacao operacao;
	private int operando1;
	private int operando2;
	private int resposta;
	
	
	public CalculadoraModel(Operacao operacao, int operando1, int operando2, int resposta) {
		this.operacao = operacao;
		this.operando1 = operando1;
		this.operando2 = operando2;
		this.resposta = resposta;
	}
	
	public int getOperando1() {
		return operando1;
	}
	
	public int getOperando2() {
		return operando2;
	}

	public int getResposta() {
		return resposta;
	}

	public Operacao getOperacao() {
		return operacao;
	}	
	
}
