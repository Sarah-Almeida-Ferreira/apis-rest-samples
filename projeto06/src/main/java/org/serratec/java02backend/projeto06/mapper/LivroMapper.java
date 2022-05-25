package org.serratec.java02backend.projeto06.mapper;

import org.serratec.java02backend.projeto06.dto.LivroDto;
import org.serratec.java02backend.projeto06.model.Livro;
import org.springframework.stereotype.Component;

@Component
public class LivroMapper {
	
    public Livro toModel(LivroDto dto){

        Livro livro = new Livro();

        livro.setAutor(dto.getAutor());
        livro.setDataPublicacao(dto.getDataPublicacao());
        livro.setGenero(dto.getGenero());
        livro.setTitulo(dto.getTitulo());

        return livro;
    }

    public LivroDto toDto(Livro livro){

        LivroDto dto = new LivroDto();

        dto.setAutor(livro.getAutor());
        dto.setDataPublicacao(livro.getDataPublicacao());
        dto.setGenero(livro.getGenero());
        dto.setTitulo(livro.getTitulo());

        return dto;
    }
}