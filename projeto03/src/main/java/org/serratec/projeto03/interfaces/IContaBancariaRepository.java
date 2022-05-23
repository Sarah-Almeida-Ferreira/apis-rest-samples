package org.serratec.projeto03.interfaces;

import org.serratec.projeto03.models.ContaBancariaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContaBancariaRepository extends JpaRepository<ContaBancariaModel,Long>{
	
}
