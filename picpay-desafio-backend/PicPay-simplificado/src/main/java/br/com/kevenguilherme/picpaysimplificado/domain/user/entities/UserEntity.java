package br.com.kevenguilherme.picpaysimplificado.domain.user.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity(name = "users")
@Table(name = "users")

public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;

    @Column(unique = true)
    private String document;
    @Column(unique = true)
    private String email;

    private String password;
    private UserType userType;
    private BigDecimal balance;

    public UserEntity(UserDTO userDTO) {

        this.name = userDTO.name();
        this.document = userDTO.document();
        this.email = userDTO.email();
        this.password = userDTO.password();
        this.userType = userDTO.userType();
        this.balance = userDTO.balance();
    }
}



