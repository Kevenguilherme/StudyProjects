package br.com.kevenguilherme.picpaysimplificado.domain.transaction.entities;

import br.com.kevenguilherme.picpaysimplificado.domain.user.entities.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity(name = "transactions")
@Table(name = "transactions")

@AllArgsConstructor
@NoArgsConstructor

public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "payer_id")
    private UserEntity payer;

    @ManyToOne
    @JoinColumn(name = "payee_id")
    private UserEntity payee;

    private LocalDateTime transactionTime;

}
