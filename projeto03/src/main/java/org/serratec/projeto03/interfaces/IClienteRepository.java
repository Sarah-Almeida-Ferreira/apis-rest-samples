package org.serratec.projeto03.interfaces;

import org.serratec.projeto03.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository <ClienteModel, Long>{
	
}
