package org.serratec.projeto03.interfaces;

import org.serratec.projeto03.models.OperacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOperacaoRepository extends JpaRepository<OperacaoModel, Long>{

}
