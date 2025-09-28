package jp.te4a.teamc.spring.boot.bookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import jp.te4a.teamc.spring.boot.bookapp.repository.ReservationRepository;
import jp.te4a.teamc.spring.boot.bookapp.bean.Reservation;

@Service
public class BookReservationService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private ReservationRepository reservationRepository;

    public void reserve(String title, String publisher, String count,
                        String name, String tel, String email) {
        Reservation reservation = new Reservation();
        reservation.setTitle(title);
        reservation.setPublisher(publisher);
        reservation.setCount(Integer.parseInt(count));
        reservation.setName(name);
        reservation.setTel(tel);
        reservation.setEmail(email);
        reservation.setIsbnCode("未入力");
        reservation.setApprovalStatus("未承認");
        reservation.setStatus("未完了");

        reservationRepository.save(reservation);
        
        /*一旦メールなし 
        if (email != null && !email.isEmpty()) {
            sendConfirmationEmail(email, title, publisher, count, name, tel);
        }
        */
    }

    public List<Reservation> findAllReservations() {
        return reservationRepository.findAll();
    }

    private void sendConfirmationEmail(String to, String title,
                                       String publisher, String count,
                                       String name, String tel) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("te200394@gmail.com");
        message.setTo(to);
        message.setSubject("【みなみかたブックス】ご予約確認の連絡");
        message.setText(
                name + " 様\n\n"
                + "この度はみなみかたブックスをご利用いただきありがとうございます。\n"
                + "--------------------------\n"
                + "タイトル: " + title + "\n"
                + "出版社: " + publisher + "\n"
                + "冊数: " + count + "\n"
                + "--------------------------\n"
                + "ご利用ありがとうございます。\n"
        );
        mailSender.send(message);
    }
}
