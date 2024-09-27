package com.ufape.preco.controlador;

import com.ufape.preco.config.RabbitMQConfig;
import com.ufape.preco.cadastro.CadastroPrecoProduto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
    @Autowired
    private CadastroPrecoProduto precoProduto;

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receiveMessage(@Payload String message) {
        Long produtotId;
        System.out.println("print!!!!" + message);
        try {
            produtotId = Long.parseLong(message.trim());
        } catch (NumberFormatException e) {
            System.err.println("Id do produto e invalido: " + message);
            return;
        }
        precoProduto.salvarPrecoParaProduto(produtotId);
    }
}
