package org.serratec.java02backend.projeto06.repository;

import java.util.List;
import org.serratec.java02backend.projeto06.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

    public List<Livro> findAllByOrderByTituloAsc();

	public List<Livro> findAllByOrderByTituloDesc();
	
	public List<Livro> findAllByOrderByIdLivroDesc();    

}