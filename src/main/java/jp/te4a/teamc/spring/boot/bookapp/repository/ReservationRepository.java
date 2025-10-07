package jp.te4a.teamc.spring.boot.bookapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.te4a.teamc.spring.boot.bookapp.bean.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    // ISBNコードで検索
    Optional<Reservation> findByIsbnCode(String isbnCode);

    // タイトル順に並べて取得
    List<Reservation> findAllByOrderByTitleAsc();

    // 完了フラグで並び替え (未完了を先、完了を後ろ)
    List<Reservation> findAllByOrderByCompletedAscIdAsc();
}
