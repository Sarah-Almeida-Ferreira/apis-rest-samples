package org.serratec.java02backend.projeto06.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.serratec.java02backend.projeto06.model.Livro;
import org.serratec.java02backend.projeto06.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {
	
	@Autowired
	LivroRepository livroRepository;

	public List<Livro> listarLivros() {

		return livroRepository.findAll();
	}

	public List<Livro> listarLivrosOrdenados(String operacao) {
		List<Livro> listaOrdenada = new ArrayList<>();
		
		switch (operacao) {
		case "titulo":
			listaOrdenada = livroRepository.findAllByOrderByTituloAsc();
			break;
		case "titulo-desc":
			listaOrdenada = livroRepository.findAllByOrderByTituloDesc();
			break;
		case "id-desc":
			listaOrdenada = livroRepository.findAllByOrderByIdLivroDesc();
		}
		
		return listaOrdenada;
	}

	public Livro buscarLivroById(Long idLivro) {
		Optional<Livro> livro = livroRepository.findById(idLivro);

		if (livro.isEmpty()) {
			return null;
		}
		
		return livro.get();		
	}
	
	public void cadastrarLivro(Livro livroCadastrado) {
		livroRepository.save(livroCadastrado);
	}
	
	public void AtualizarLivro(Long idLivro, Livro livro) {
		Livro livroUpdated = buscarLivroById(idLivro);
		
		if(livro.getAutor() != null) {			
			livroUpdated.setAutor(livro.getAutor());
		}
		if(livro.getTitulo() != null) {			
			livroUpdated.setTitulo(livro.getTitulo());
		}
		if(livro.getDataPublicacao() != null) {			
			livroUpdated.setDataPublicacao(livro.getDataPublicacao());
		}
		if(livro.getGenero() != null) {			
			livroUpdated.setGenero(livro.getGenero());
		}
		
		livroRepository.save(livroUpdated);
	}
	
	public void deletarLivro(Long idLivro) {
		livroRepository.deleteById(idLivro);
	}

}