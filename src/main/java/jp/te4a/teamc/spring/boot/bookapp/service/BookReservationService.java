package jp.te4a.teamc.spring.boot.bookapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import jp.te4a.teamc.spring.boot.bookapp.repository.ReserveRepository;

import jp.te4a.teamc.spring.boot.bookapp.bean.Reserve;

@Service
public class BookReservationService {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private ReserveRepository reserveRepository;

    public void reserve(String title, String publisher, String count, String name, String tel, String address) {
        // 必要ならDB保存などをここでやる
        Reserve reserve = new Reserve();
        reserve.setTitle(title);
        reserve.setPublisher(publisher);
        reserve.setCount(Integer.parseInt(count));
        reserve.setName(name);
        reserve.setTel(tel);
        reserve.setAddress(address);

        reserveRepository.save(reserve); // H2 に保存！
         if (address != null && !address.isEmpty()) {
        try {
            sendConfirmationEmail(address, title, publisher, count, name, tel);
        } catch (Exception e) {
            System.out.println("メール送信に失敗しました: " + e.getMessage());
            e.printStackTrace();
        }
    }
    }

    private void sendConfirmationEmail(String to, String title, String publisher, String count, String name, String tel) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("【みなみかたブックス】ご予約確認の連絡");
        message.setText(
                name + " 様\n\n"
                + "この度はみなみかたブックスをご利用いただきありがとうございます。\n"
                + "--------------------------\n"
                + "タイトル \n"
                + title + "\n"
                + "出版社 \n"
                + publisher + "\n"
                + "冊数 \n"
                + count + "\n"
                + "で受けたまりました。\n"
                + "--------------------------\n"
                + "ご利用ありがとうございます。\n"
        );
        message.setFrom("te200394@gmail.com");

        mailSender.send(message);
    }
}
