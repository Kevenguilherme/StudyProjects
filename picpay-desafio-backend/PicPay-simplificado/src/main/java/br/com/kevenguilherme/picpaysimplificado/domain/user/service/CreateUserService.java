package br.com.kevenguilherme.picpaysimplificado.domain.user.service;

import br.com.kevenguilherme.picpaysimplificado.domain.user.entities.UserDTO;
import br.com.kevenguilherme.picpaysimplificado.domain.user.entities.UserEntity;
import br.com.kevenguilherme.picpaysimplificado.domain.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Objects;

@Service
public class CreateUserService {

    @Autowired
    private UserRepository userRepository;

    private void saveUser(UserEntity userEntity) {
        this.userRepository.save(userEntity);
    }

  public UserEntity createUser (UserDTO userEntity) {
      UserEntity newUserEntity = new UserEntity(userEntity);
      this.saveUser(newUserEntity);
      return newUserEntity;

  }

}
