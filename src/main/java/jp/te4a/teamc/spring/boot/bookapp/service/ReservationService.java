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

    // 全予約一覧を取得
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    // 承認処理
    public void approve(Map<String, String> params) {
        // 例としてtitleとnameで予約を特定（本来はIDで検索するのが望ましい）
        String title = params.get("title");
        String name = params.get("name");

        Optional<Reservation> optional = reservationRepository.findAll().stream()
                .filter(r -> r.getTitle().equals(title) && r.getName().equals(name))
                .findFirst();

        if (optional.isPresent()) {
            Reservation reservation = optional.get();
            reservation.setApprovalStatus("承認済み");
            reservation.setApprovalDate(LocalDate.now());
            reservationRepository.save(reservation);
        }
    }

    // 取引完了処理
    public void complete(Map<String, String> params) {
        String title = params.get("title");
        String name = params.get("name");

        Optional<Reservation> optional = reservationRepository.findAll().stream()
                .filter(r -> r.getTitle().equals(title) && r.getName().equals(name))
                .findFirst();

        if (optional.isPresent()) {
            Reservation reservation = optional.get();
            reservation.setStatus("完了");
            reservationRepository.save(reservation);
        }
    }
}
