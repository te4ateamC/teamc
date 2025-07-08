package jp.te4a.teamc.spring.boot.bookapp.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdrBean {
    @Column(nullable=false)
    private String title;
    @Column(nullable=false)
    private String publisher;
    @Column(nullable=false)
    private String count;
    @Column(nullable=false)
    private String name;
    @Column(nullable=false)
    private String tel;
    private Integer address;
    @Column (nullable=false)
    @PrimaryKeyJoinColumn
    private String code;
    private String date;
    private String many;
}