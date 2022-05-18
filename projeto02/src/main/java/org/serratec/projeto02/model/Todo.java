package org.serratec.projeto02.model;

public class Todo {
	
	private Integer id;
	private String titulo;
	private String descricao;
	
	public Todo() {
	
	}
	
	public Todo(Integer id, String titulo, String descricao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}
		

}
