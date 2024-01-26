package br.com.kevenguilherme.picpaysimplificado.domain.user.repositories;

import br.com.kevenguilherme.picpaysimplificado.domain.user.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*Quando eu estendo a JpaRepository eu preciso passar a Entity e a estratégia
de id*/
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
