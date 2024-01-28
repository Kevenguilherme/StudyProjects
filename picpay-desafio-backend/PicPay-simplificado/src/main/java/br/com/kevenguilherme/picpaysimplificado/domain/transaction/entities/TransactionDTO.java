package br.com.kevenguilherme.picpaysimplificado.domain.transaction.entities;

import java.math.BigDecimal;

public record TransactionDTO(

        BigDecimal amount,
        Long payerId,
        Long payeeId
) {}
