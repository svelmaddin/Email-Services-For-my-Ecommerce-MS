package com.example.emailSender.services;

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
        String productNames = String.join(", ", order.getProductNames());
        String body = "Dear" + order.getCustomerName() + "!" +
                "\nyour order Id :    " + order.getOrderId() +
                "\norder status :   " + order.getOrderStatus() +
                "\norder details :   " + productNames +
                "\nOrder totalPrice :   " + order.getTotalPrice() +
                "\nOrder DeliveryAddress :   " + order.getDeliveryAddress() +
                "\nOrder discount :   " + order.getDiscount() +
                "\nThank you for shop.";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("elmeddin.sv@gmail.com");
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
