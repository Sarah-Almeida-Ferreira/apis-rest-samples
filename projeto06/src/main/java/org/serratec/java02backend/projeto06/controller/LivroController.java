package org.serratec.java02backend.projeto06.controller;

import java.util.List;
import org.serratec.java02backend.projeto06.dto.LivroDto;
import org.serratec.java02backend.projeto06.mapper.LivroMapper;
import org.serratec.java02backend.projeto06.model.Livro;
import org.serratec.java02backend.projeto06.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livro")
public class LivroController {
	
	@Autowired
	LivroService livroService;
	
	@Autowired
	LivroMapper livroMapper;
	
	@GetMapping
	public ResponseEntity<List<Livro>> listarLivros() {
		return ResponseEntity.ok(livroService.listarLivros());
	}

	@GetMapping("/lista-ordenada")
	public ResponseEntity<List<Livro>> listarLivrosOrdenados(@RequestParam String operacao){
		return ResponseEntity.ok(livroService.listarLivrosOrdenados(operacao));
	}
	
	@GetMapping("/{idLivro}")
	public ResponseEntity<LivroDto> buscarLivroById(@PathVariable Long idLivro) {
        Livro livro = livroService.buscarLivroById(idLivro);
        return ResponseEntity.ok(livroMapper.toDto(livro));
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	public void cadastrarLivro(@RequestBody LivroDto livroCadastrado) {		
        livroService.cadastrarLivro(livroMapper.toModel(livroCadastrado));
	}
	
	@PutMapping("/{idLivro}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void atualizarLivro(@PathVariable Long idLivro, @RequestBody LivroDto livroAtualizado) {
		livroService.AtualizarLivro(idLivro, livroMapper.toModel(livroAtualizado));
	}
	
	@DeleteMapping("/{idLivro}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void deletarLivro(@PathVariable Long idLivro) {
        livroService.deletarLivro(idLivro);
	}

}