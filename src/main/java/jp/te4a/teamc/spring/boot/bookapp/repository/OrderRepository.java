package jp.te4a.teamc.spring.boot.bookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.te4a.teamc.spring.boot.bookapp.bean.OrderBean;

@Repository
public interface OrderRepository extends JpaRepository<OrderBean, String> {
    // 第二引数の String は主キーの型です（OrderBean の @Id によって変わります）
}
