package br.com.kevenguilherme.picpaysimplificado.domain.transaction.repositories;

import br.com.kevenguilherme.picpaysimplificado.domain.transaction.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacitonRepository extends JpaRepository<TransactionEntity, Long> {
}
