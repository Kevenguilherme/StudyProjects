package br.com.kevenguilherme.picpaysimplificado.domain.transaction.controller;

import br.com.kevenguilherme.picpaysimplificado.domain.transaction.entities.TransactionDTO;
import br.com.kevenguilherme.picpaysimplificado.domain.transaction.entities.TransactionEntity;
import br.com.kevenguilherme.picpaysimplificado.domain.transaction.service.TransactionService;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransactionEntity> createTransaction(@RequestBody TransactionDTO transactionDTO) throws Exception {
        var newTransaction =
                this.transactionService.createTransaciton(transactionDTO);
        return new ResponseEntity<>(newTransaction, HttpStatus.OK);

    }
}
