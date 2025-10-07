package jp.te4a.teamc.spring.boot.bookapp.bean;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "reservations")
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String publisher;
    private Integer count;
    private String name;
    private String tel;
    private String email;
    private String isbnCode;
    private LocalDate approvalDate;
    private Integer amount;
    private String approvalStatus; // 例: "未承認", "承認済み"
    private String status;         // 例: "未完了", "完了"

    private boolean completed = false;
    
    public String getIsbnCode() {
        return isbnCode;
    }

    public void setIsbnCode(String isbnCode) {
        this.isbnCode = isbnCode;
    }
}
