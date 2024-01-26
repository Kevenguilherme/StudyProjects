package br.com.kevenguilherme.picpaysimplificado.domain.user.controller;

import br.com.kevenguilherme.picpaysimplificado.domain.user.entities.UserDTO;
import br.com.kevenguilherme.picpaysimplificado.domain.user.entities.UserEntity;
import br.com.kevenguilherme.picpaysimplificado.domain.user.service.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private CreateUserService createUserService;

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserDTO userEntity) {
        UserEntity newUserEntity = createUserService.createUser(userEntity);
        return new ResponseEntity<>(newUserEntity, HttpStatus.CREATED);

    }
}
