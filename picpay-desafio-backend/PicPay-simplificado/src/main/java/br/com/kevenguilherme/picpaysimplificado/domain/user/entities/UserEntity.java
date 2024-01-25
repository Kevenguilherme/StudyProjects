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
    private String Document;
    @Column(unique = true)
    private String email;

    private String password;
    private UserType userType;
    private BigDecimal balance;


}



