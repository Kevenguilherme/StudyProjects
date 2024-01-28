package br.com.kevenguilherme.picpaysimplificado.domain.notifications;

import br.com.kevenguilherme.picpaysimplificado.domain.user.entities.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class NotificationsService {


    public void sendNotification(UserEntity userEntity, String message){
        String email = userEntity.getEmail();
        System.out.println(email+message);

    }

}
