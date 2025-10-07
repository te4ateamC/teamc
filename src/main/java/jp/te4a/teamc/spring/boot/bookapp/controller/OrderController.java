package jp.te4a.teamc.spring.boot.bookapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Map;

import jp.te4a.teamc.spring.boot.bookapp.bean.Reservation;
import jp.te4a.teamc.spring.boot.bookapp.service.ReservationService;
import jp.te4a.teamc.spring.boot.bookapp.service.reservationRepository;

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
    public String complete(@RequestParam("id") Long id) {
        reservationService.complete(id);
        return "redirect:/orderhistory";
    }

}
