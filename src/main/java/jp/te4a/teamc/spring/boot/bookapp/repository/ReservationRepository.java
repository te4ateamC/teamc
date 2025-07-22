package jp.te4a.teamc.spring.boot.bookapp.repository;

import jp.te4a.teamc.spring.boot.bookapp.bean.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    
}
