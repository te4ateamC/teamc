package jp.te4a.teamc.spring.boot.bookapp.service;

import jp.te4a.teamc.spring.boot.bookapp.bean.Reservation;
import jp.te4a.teamc.spring.boot.bookapp.repository.ReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    // ステータス更新
    public void updateStatus(String isbnCode, String status) {
        Optional<Reservation> optional = reservationRepository.findByIsbnCode(isbnCode);
        if (optional.isPresent()) {
            Reservation r = optional.get();
            r.setStatus(status);
            reservationRepository.save(r);
        }
    }

    // 承認処理
    public void approve(Map<String, String> params) {

        String title = params.get("title");
        String name = params.get("name");

        List<Reservation> allReservations = reservationRepository.findAll();

        Optional<Reservation> optional = allReservations.stream()
                .filter(r -> r.getTitle().equals(title) && r.getName().equals(name))
                .findFirst();
                
                
        System.out.println("デバッグ用");
        
        if (optional.isPresent()) {
            Reservation reservation = optional.get();
            reservation.setIsbnCode(null);
            reservation.setAmount(null);
            reservation.setApprovalStatus("未承認");
            reservation.setApprovalDate(LocalDate.now());
            reservationRepository.save(reservation);
            //System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        }
    }

    // 取引完了処理
    public void complete(Map<String, String> params) {
        String title = params.get("title");
        String name = params.get("name");

        List<Reservation> allReservations = reservationRepository.findAll();

        Optional<Reservation> optional = allReservations.stream()
                .filter(r -> r.getTitle().equals(title) && r.getName().equals(name))
                .findFirst();

        if (optional.isPresent()) {
            Reservation reservation = optional.get();
            reservation.setStatus("完了");
            reservationRepository.save(reservation);
        }
    }

    // 全予約一覧を取得
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }
}
