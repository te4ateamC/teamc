package jp.te4a.teamc.spring.boot.bookapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import jp.te4a.teamc.spring.boot.bookapp.bean.OrderBean;
import jp.te4a.teamc.spring.boot.bookapp.service.OrderService;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orderHistory")
    public String showOrderHistory(Model model) {
        List<OrderBean> orderList = orderService.findAll(); // サンプル
        model.addAttribute("orderList", orderList);
        return "orderHistory"; // Thymeleafテンプレート名
    }

    @PostMapping("/reserveappro")
        public String approveReservation(@RequestParam("title") String title,
                                     @RequestParam("publisher") String publisher,
                                     @RequestParam("count") String count,
                                     @RequestParam("name") String name,
                                     @RequestParam("ISBNcode") String isbnCode,
                                     @RequestParam("amount") String amount,
                                     Model model) {

        // 本来はDB更新など行うところ（ここでは省略）

        // モデルに格納して、画面に返す
        model.addAttribute("title", title);
        model.addAttribute("publisher", publisher);
        model.addAttribute("count", count);
        model.addAttribute("name", name);
        model.addAttribute("isbnCode", isbnCode);
        model.addAttribute("amount", amount);
        model.addAttribute("approvalStatus", "承認済み");
        model.addAttribute("approvalDate", LocalDate.now().toString());

        // OrderHistory.html へ表示（Thymeleafテンプレート）
        return "OrderHistory"; // → src/main/resources/templates/OrderHistory.html
    }
}
