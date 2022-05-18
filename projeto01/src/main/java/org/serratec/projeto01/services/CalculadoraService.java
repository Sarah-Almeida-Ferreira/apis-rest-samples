package org.serratec.projeto01.services;

import org.serratec.projeto01.enums.Operacao;
import org.serratec.projeto01.models.CalculadoraModel;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {
		
	public CalculadoraModel somar(int operando1,int operando2) {
		
		CalculadoraModel model = new CalculadoraModel(Operacao.SOMA, operando1,operando2,(operando1+operando2));
		
		return model;
	}
	
	public CalculadoraModel subtrair(int operando1,int operando2) {		
		CalculadoraModel model = new CalculadoraModel(Operacao.SUBTRACAO,operando1,operando2,(operando1-operando2));
		
		return model;
	}
	
	public CalculadoraModel multiplicar(int operando1,int operando2) {		
		CalculadoraModel model = new CalculadoraModel(Operacao.MULTIPLICACAO,operando1,operando2,(operando1*operando2));
		
		return model;
	}
	
	public CalculadoraModel dividir(int operando1,int operando2) {		
		CalculadoraModel model = new CalculadoraModel(Operacao.DIVISAO,operando1,operando2,(operando1/operando2));
		
		return model;
	}
	
}
