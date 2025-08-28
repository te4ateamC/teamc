package jp.te4a.teamc.spring.boot.bookapp.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bookreservation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reserve {
    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // または AUTO
    private Integer id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String publisher;
    @Column(nullable = false)
    private Integer count;
    @Column
    private String isbnCode;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String tel;
    private String address;
}
