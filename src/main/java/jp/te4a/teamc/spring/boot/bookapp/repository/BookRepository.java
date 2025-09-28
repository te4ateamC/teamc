package jp.te4a.teamc.spring.boot.bookapp.repository;

import java.util.List;

//import org.apache.catalina.servlets.DefaultServlet.SortManager.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jp.te4a.teamc.spring.boot.bookapp.bean.OrderBean;

@Repository

    public interface BookRepository extends JpaRepository<OrderBean,String> {

        @Query("SELECT X FROM OrderBean X ORDER BY X.title")
        
        
        List<OrderBean>findAllByOrderByTitleAsc();
    }