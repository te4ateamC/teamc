package jp.te4a.teamc.spring.boot.bookapp.bean;

import jakarta.persistence.*;

@Entity
@Table(name = "book") // 実際のテーブル名に合わせてください
public class BookBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    // 他のフィールド、getter/setter...
}
