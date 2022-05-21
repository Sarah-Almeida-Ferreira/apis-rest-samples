package org.serratec.projeto03.interfaces;

import org.serratec.projeto03.models.OperacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOperacaoRepository extends JpaRepository<OperacaoModel, Long>{

}
