package com.example.emailSender.services;

import com.example.emailSender.response.OrderResponse;
import com.example.emailSender.response.OrderStatusEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;
    private final RestTemplate restTemplate;

    public EmailSenderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void sendMailToCustomerAboutOrderStatus(OrderStatusEmail order) {
        String customerEmail = userEmailsResponse(order.getCustomerId());
        String storeEmail = storeEmailsResponse(order.getStoreId());
        String body = "Dear customer! \nyour order Id :    " + order.getOrderId() +
                "\norder status :   " + order.getOrderStatus() +
                "\norder details :   " + order.getDetails() +
                "\nOrder totalPrice :   " + order.getPrice() +
                "\nThank you for shop.";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(storeEmail);
        message.setTo(customerEmail);
        message.setText(body);
        message.setSubject("TEST");
        javaMailSender.send(message);
        System.out.println("email sent was successfully to : " + order.getCustomerId());
    }

    private String userEmailsResponse(String userId) {
        String URL = "http://localhost:9091/user/getEmailByUserId/" + userId;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL, String.class);
        return responseEntity.getBody();
    }

    private String storeEmailsResponse(String userId) {
        String URL = "http://localhost:9091/user/getEmailByUserId/" + userId;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL, String.class);
        return responseEntity.getBody();
    }

}
