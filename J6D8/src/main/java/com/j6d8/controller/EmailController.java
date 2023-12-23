package com.j6d8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.j6d8.entity.Account;
import com.j6d8.repository.AccountRepository;
import com.j6d8.service.AccountService;

import net.bytebuddy.utility.RandomString;

@Controller
@RequestMapping("/email")
public class EmailController {
    @Autowired
    AccountService accountService;

    @Autowired
    JavaMailSender javaMailSender;

    @GetMapping("/feedback")
    public String feedback() {
        return "feedback/fb";
    }

    @PostMapping("/feedback/succsess")
    public String fbsuccess(Model model,
                            @RequestParam("Name") String Name,
                            @RequestParam("PhoneNumber") String PhoneNumber,
                            @RequestParam("Subject") String Subject,
                            @RequestParam("Message") String Message) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("tuetritmt41@gmail.com");
        msg.setText(Name);
        msg.setText(PhoneNumber);
        msg.setSubject(Subject);
        msg.setText(Message);
        javaMailSender.send(msg);
        model.addAttribute("message", "Gửi email thành công!");
        return "feedback/fb";
    }


}
