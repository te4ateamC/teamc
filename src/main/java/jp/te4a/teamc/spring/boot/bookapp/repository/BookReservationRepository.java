package jp.te4a.teamc.spring.boot.bookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import jp.te4a.teamc.spring.boot.bookapp.bean.BookReservation;

@Repository
public interface BookReservationRepository extends JpaRepository<BookReservation, Long> {
    
}