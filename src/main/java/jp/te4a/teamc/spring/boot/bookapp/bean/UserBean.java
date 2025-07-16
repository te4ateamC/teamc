package jp.te4a.teamc.spring.boot.bookapp.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBean {
    @Column(nullable=false)
    @Id
    private String id;
    @Column(nullable=false)
    private String title;
    @Column(nullable=false)
    private String publisher;
    @Column(nullable=false)
    private String count;
    @Column(nullable=false)
    private String name;
    private String address;
}
