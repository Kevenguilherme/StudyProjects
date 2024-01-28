package br.com.kevenguilherme.picpaysimplificado.domain.transaction.service;

import br.com.kevenguilherme.picpaysimplificado.domain.notifications.NotificationsService;
import br.com.kevenguilherme.picpaysimplificado.domain.transaction.entities.TransactionDTO;
import br.com.kevenguilherme.picpaysimplificado.domain.transaction.entities.TransactionEntity;
import br.com.kevenguilherme.picpaysimplificado.domain.transaction.repositories.TransacitonRepository;
import br.com.kevenguilherme.picpaysimplificado.domain.user.service.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class TransactionService {

    @Autowired
    private CreateUserService createUserService;


   @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TransacitonRepository transacitonRepository;

    @Autowired
    private NotificationsService notificationsService;

    public TransactionEntity createTransaciton(TransactionDTO transactionDTO) throws Exception {
        var payer = this.createUserService.findUserById(transactionDTO.payerId());
        var payee = this.createUserService.findUserById(transactionDTO.payeeId());

        createUserService.validateUser(payer, transactionDTO.amount());

        boolean isAuthorize = authorizeTransaction();

        if (!isAuthorize) {
            throw new Exception("Transação não autorizada");
        }

        TransactionEntity newTransaction = new TransactionEntity();
        newTransaction.setAmount(transactionDTO.amount());
        newTransaction.setPayer(payer);
        newTransaction.setPayee(payee);
        newTransaction.setTransactionTime(LocalDateTime.now());

        payer.setBalance(payer.getBalance().subtract(transactionDTO.amount()));
        payee.setBalance(payee.getBalance().add(transactionDTO.amount()));

        this.transacitonRepository.save(newTransaction);
        this.createUserService.saveUser(payer);
        this.createUserService.saveUser(payee);

        notificationsService.sendNotification(payer, "Transação realizada com sucesso");
        notificationsService.sendNotification(payee,"Transação recebida com sucesso");

        return newTransaction;
    }

    public boolean authorizeTransaction() {
        var response = restTemplate.getForEntity("https://run.mocky.io/v3/5794d450-d2e2-4412-8131" +
                "-73d0293ac1cc", Map.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            String message = (String) response.getBody().get("message");
            return "Autorizado".equalsIgnoreCase(message);

        } else return false;
    }
}
