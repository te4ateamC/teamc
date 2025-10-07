package jp.te4a.teamc.spring.boot.bookapp.service;

import jp.te4a.teamc.spring.boot.bookapp.bean.Reservation;
import jp.te4a.teamc.spring.boot.bookapp.repository.ReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    // ステータス更新（任意利用）
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
        String isbnCode = params.get("isbnCode");
        String amountStr = params.get("amount");

        List<Reservation> allReservations = reservationRepository.findAll();

        Optional<Reservation> optional = allReservations.stream()
                .filter(r -> r.getTitle().equals(title) && r.getName().equals(name))
                .findFirst();

        if (optional.isPresent()) {
            Reservation reservation = optional.get();
            reservation.setIsbnCode(isbnCode);
            reservation.setAmount(Integer.parseInt(amountStr));
            reservation.setApprovalStatus("承認済み");
            reservation.setApprovalDate(LocalDate.now());
            reservationRepository.save(reservation);
        } else {
            throw new RuntimeException("予約が見つかりません: " + title + ", " + name);
        }
    }

    // 取引完了処理
    public void complete(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("予約が存在しません: " + id));
        reservation.setCompleted(true); // 完了フラグをON
        reservationRepository.save(reservation);
    }

    public List<Reservation> findAll() {
        // 完了してないもの → 完了したもの の順で並べて返す
        List<Reservation> all = reservationRepository.findAll();
        all.sort(Comparator.comparing(Reservation::isCompleted));
        return all;
    }
}
