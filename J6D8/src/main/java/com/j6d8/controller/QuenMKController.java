package com.j6d8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.mail.javamail.JavaMailSender;

import com.j6d8.entity.Account;
import com.j6d8.repository.AccountRepository;
import com.j6d8.service.AccountService;

import net.bytebuddy.utility.RandomString;

@Controller
@RequestMapping("/quenmk")
public class QuenMKController {

    @Autowired
    AccountService accountService;

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping("/form")
    public String DoiMK(Model model) {
        model.addAttribute("message", "Vui lòng nhập thông tin!");
        return "forgotMK/forgotpw";
    }

    @PostMapping("/verifycode")
    public String forgerpass(Model model, @RequestParam("username") String username,
                             @RequestParam("email") String email) {

        if (username.length() == 0 && email.length() == 0) {
            model.addAttribute("message", "username hoặc email của bạn ko được để trống");
            return "/forgotMK/forgotpw";
        }
        Account user = accountService.finById(username);
        if (username.equalsIgnoreCase(user.getUsername())) {
            if (email.equalsIgnoreCase(user.getEmail())) {
                SimpleMailMessage msg = new SimpleMailMessage();
                msg.setTo("tuetritmt41@gmail.com");
                msg.setSubject(email);
                msg.setText(username);
                String randomCode = RandomString.make(6);
                msg.setText(randomCode);
                javaMailSender.send(msg);
                user.setVerifycode(randomCode);
                accountRepository.save(user);
                model.addAttribute("message", "Nhập mã xác thực!");
                return "/forgotMK/verifycode";
            } else {
                model.addAttribute("message", "Vui lòng nhập lại Email!");
                return "/forgotMK/forgotpw";
            }
        } else {
            model.addAttribute("message", "Vui lòng nhập lại username");
            return "/forgotMK/forgotpw";
        }
    }


    @PostMapping("/verifycode/success")
    public String verifycodesuccess(Model model, @RequestParam("username") String username,
                                    @RequestParam("password") String password, @RequestParam("verifycode") String verifycode) {
        Account user = accountService.finById(username);
        if (user.getVerifycode().equalsIgnoreCase(verifycode)) {
            user.setVerifycode(null);
            user.setPassword(password);
            accountRepository.save(user);
        }
        model.addAttribute("message", "Lấy lại mật khẩu thành công. Vui lòng đăng nhập!");
        return "security/login";
    }

}
