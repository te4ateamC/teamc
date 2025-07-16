package jp.te4a.teamc.spring.boot.bookapp.form;

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
@Table(name="userform")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {
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
