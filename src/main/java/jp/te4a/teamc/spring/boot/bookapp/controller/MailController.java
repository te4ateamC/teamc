package jp.te4a.teamc.spring.boot.bookapp.controller;

import jp.te4a.teamc.spring.boot.bookapp.bean.Nortification;
import jp.te4a.teamc.spring.boot.bookapp.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private MailService mailService;

    @PostMapping("/send")
    public String sendMail(@RequestBody Nortification userInfo) {
        String to = userInfo.getAddress();
        String subject = "こんにちは " + userInfo.getName() + " さん";
        String text = "これはSpring Bootからのテストメールです。";
        mailService.sendMail(to, subject, text);
        return "メール送信完了";
    }
}
