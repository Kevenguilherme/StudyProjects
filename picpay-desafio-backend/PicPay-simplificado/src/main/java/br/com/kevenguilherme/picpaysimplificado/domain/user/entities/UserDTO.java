package br.com.kevenguilherme.picpaysimplificado.domain.user.entities;

import jakarta.persistence.Column;

import java.math.BigDecimal;

public record UserDTO(
        String name,
        String document,
        String email,
        String password,
        UserType userType,
        BigDecimal balance
) {
}
