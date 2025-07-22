package jp.te4a.teamc.spring.boot.bookapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.te4a.teamc.spring.boot.bookapp.service.ReservationService;
import jp.te4a.teamc.spring.boot.bookapp.bean.Reservation;


@Controller
public class ReservationController {

    @GetMapping("/order-history")
    public String showOrderHistory(Model model) {
        List<Reservation> reservationList = new ArrayList<>();

        Reservation sample1 = new Reservation();
        sample1.setTitle("Java入門");
        sample1.setPublisher("技術評論社");
        sample1.setCount(3);
        sample1.setName("山田太郎");
        sample1.setTel("090-1234-5678");
        sample1.setEmail("yamada@example.com");
        sample1.setISBNcode("9784774197151");
        sample1.setApprovalDate(LocalDate.now());
        sample1.setAmount(6000);
        sample1.setApprovalStatus("未承認");
        sample1.setStatus("未完了");

        Reservation sample2 = new Reservation();
        sample2.setTitle("HTML入門");
        sample2.setPublisher("技術評論社");
        sample2.setCount(2);
        sample2.setName("山田花子");
        sample2.setTel("090-5678-1234");
        sample2.setEmail("hanako@example.com");
        sample2.setISBNcode("1597648312548");
        sample2.setApprovalDate(LocalDate.now());
        sample2.setAmount(4000);
        sample2.setApprovalStatus("未承認");
        sample2.setStatus("未完了");

        reservationList.add(sample1);
        reservationList.add(sample2);

        model.addAttribute("reservationList", reservationList);
        return "OrderHistory"; // orderReception.html を返す
    }
}
