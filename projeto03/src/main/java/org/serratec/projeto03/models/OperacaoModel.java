package org.serratec.projeto03.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.serratec.projeto03.enums.TipoOperacao;

@Entity
@Table(name="operacao")
public class OperacaoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "operacao_id")
	private Long idOperacao;
	
	@Column(name = "tipo_operacao")
	private TipoOperacao tipoOperacao;
	
	@Column(name = "valor_operacao")
	private Double valorOperacao;
	
	@ManyToOne
	@JoinColumn(name = "conta_bancaria_id")
	private ContaBancariaModel contaBancaria;

}
