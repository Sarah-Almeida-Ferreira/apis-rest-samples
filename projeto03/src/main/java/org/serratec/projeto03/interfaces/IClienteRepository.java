package org.serratec.projeto03.interfaces;

import org.serratec.projeto03.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<ClienteModel, Long>{

	public ClienteModel findByCpf(String cpf);
	
}
