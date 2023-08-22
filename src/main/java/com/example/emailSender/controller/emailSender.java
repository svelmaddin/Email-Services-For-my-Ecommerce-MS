package com.example.emailSender.controller;

import com.example.emailSender.response.OrderResponse;
import com.example.emailSender.services.EmailSenderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class emailSender {
    private final EmailSenderService emailSenderService;

    public emailSender(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping("/emailSendToCustomer")
    public ResponseEntity<String> sendMailToCustomerAboutOrderStatus(@RequestBody OrderResponse orderResponse) {
        emailSenderService.sendMailToCustomerAboutOrderStatus(orderResponse);
        return ResponseEntity.ok("Email Has been sent successfully");
    }



}
