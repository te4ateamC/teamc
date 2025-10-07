package jp.te4a.teamc.spring.boot.bookapp.bean;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "bookreservation")
@Data
public class BookReservation {

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
    private String address;
}