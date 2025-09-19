package jp.te4a.teamc.spring.boot.bookapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Map;

import jp.te4a.teamc.spring.boot.bookapp.service.ReservationService;

@Controller
public class OrderController {

    @Autowired
    private ReservationService reservationService;

    // OrderHistoryからの遷移
    @GetMapping("/reserveappro")
    public String showReserveAppro(@RequestParam Map<String, String> params, Model model, HttpServletRequest request) {
        // モデルに予約情報
        model.addAttribute("reservation", params);

        // CSRFトークン追加
        CsrfToken token = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        model.addAttribute("_csrf", token);

        return "reserveappro";
    }

    @PostMapping("/complete")
public String completeReservation(
        @RequestParam String title,
        @RequestParam String publisher,
        @RequestParam String count,
        @RequestParam String name,
        @RequestParam String isbnCode,
        @RequestParam String approvalDate,
        @RequestParam String amount,
        @RequestParam String approvalStatus,
        @RequestParam String status,
        Model model) {


    return "redirect:/orderHistory"; // 完了後に一覧へリダイレクト
}


}
