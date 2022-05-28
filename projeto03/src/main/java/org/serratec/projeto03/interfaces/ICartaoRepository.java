package org.serratec.projeto03.interfaces;

import org.serratec.projeto03.models.CartaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartaoRepository extends JpaRepository<CartaoModel, Long>{

}
