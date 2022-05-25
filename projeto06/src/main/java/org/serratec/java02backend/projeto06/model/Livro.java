package org.serratec.java02backend.projeto06.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "livro_cd_livro")
	private Long idLivro;
	
	@NotNull
	@Size(min = 5, max = 30)
	@Column(name = "livro_tx_titulo")
	private String titulo;
	
	@NotNull
	@Size(min = 3, max = 20)
	@Column(name = "livro_tx_genero")
	private String genero;
	
	@NotNull
	@Size(min = 10, max = 40)
	@Column(name = "livro_tx_autor")
	private String autor;
	
	@Column(name = "livro_dt_publicacao")
	private Date dataPublicacao;

	public Livro() {}

	public Livro(@NotNull @Size(min = 5, max = 30) String titulo, @NotNull @Size(min = 3, max = 20) String genero,
			@NotNull @Size(min = 10, max = 40) String autor, Date dataPublicacao) {
		this.titulo = titulo;
		this.genero = genero;
		this.autor = autor;
		this.dataPublicacao = dataPublicacao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}	
}