/*package jp.te4a.teamc.spring.boot.bookapp.repository;

import java.util.List;

//import org.apache.catalina.servlets.DefaultServlet.SortManager.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jp.te4a.teamc.spring.boot.bookapp.bean.Reserve;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve,Integer> {

    @Query("SELECT r FROM Reserve r ORDER BY r.title")
    List<Reserve> findAllOrderByTitle();

    // ISBNコードで検索するメソッドを追加
    Reserve findByIsbnCode(String isbnCode);
}
    */