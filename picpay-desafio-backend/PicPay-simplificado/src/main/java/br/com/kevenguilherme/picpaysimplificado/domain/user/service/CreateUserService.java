package br.com.kevenguilherme.picpaysimplificado.domain.user.service;

import br.com.kevenguilherme.picpaysimplificado.domain.user.entities.UserDTO;
import br.com.kevenguilherme.picpaysimplificado.domain.user.entities.UserEntity;
import br.com.kevenguilherme.picpaysimplificado.domain.user.entities.UserType;
import br.com.kevenguilherme.picpaysimplificado.domain.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Service
public class CreateUserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(UserEntity userEntity) {
        this.userRepository.save(userEntity);
    }

    public UserEntity createUser(UserDTO userEntity) {
        UserEntity newUserEntity = new UserEntity(userEntity);
        this.saveUser(newUserEntity);
        return newUserEntity;

    }

    public List<UserEntity> getAllUsers() {
        return this.userRepository.findAll();
    }

    public UserEntity findUserById(Long id) throws Exception {
        return this.userRepository.findById(id).orElseThrow(() ->
                new Exception("Usuário não encontrado"));

    }

    public Boolean validateUser(UserEntity payer, BigDecimal amount) throws Exception {
        if(payer.getUserType() == UserType.MERCHANT) {
            throw new Exception("Usuário do tipo lógista não pode realizar " +
                    "transações.");
        }

        if(payer.getBalance().compareTo(amount) < 0){
            throw new Exception("Saldo insuficiente");
        }

        return  true;
    }
}
