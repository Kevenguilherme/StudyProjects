package br.com.kevenguilherme.picpaysimplificado.domain.user.controller;

import br.com.kevenguilherme.picpaysimplificado.domain.user.entities.UserDTO;
import br.com.kevenguilherme.picpaysimplificado.domain.user.entities.UserEntity;
import br.com.kevenguilherme.picpaysimplificado.domain.user.service.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        var allUsers = this.createUserService.getAllUsers();
       return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
}
