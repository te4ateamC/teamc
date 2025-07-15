package jp.te4a.teamc.spring.boot.bookapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import java.util.List;


import jp.te4a.teamc.spring.boot.bookapp.bean.OrderBean;
import jp.te4a.teamc.spring.boot.bookapp.service.OrderService;

public class OrderController {

    @Autowired
private OrderService orderService;

    @GetMapping("/orderHistory")
public String showOrderHistory(Model model) {
    List<OrderBean> orderList = orderService.findAll(); // サンプル
    model.addAttribute("orderList", orderList);
    return "orderHistory"; // Thymeleafテンプレート名
}

}
