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
import jp.te4a.teamc.spring.boot.bookapp.repository.ReservationRepository;

@Controller
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/orderhistory")
    public String showOrderHistory(Model model) {
        // DBから全部取得
        var reservationList = reservationRepository.findAll();

        // モデルに渡す
        model.addAttribute("reservationList", reservationList);
        return "OrderHistory";
    }

    @PostMapping("/reserveappro")
    public String showApprovalForm(@RequestParam Map<String, String> params, Model model) {
        // OrderHistoryから渡されたデータを承認画面に渡す
        model.addAttribute("title", params.get("title"));
        model.addAttribute("publisher", params.get("publisher"));
        model.addAttribute("count", params.get("count"));
        model.addAttribute("name", params.get("name"));
        return "reserveappro"; // 承認画面へ
    }

    @PostMapping("/reserveappro/confirm")
    public String confirmApproval(@RequestParam Map<String, String> params, Model model) {
        // 入力チェック
        String isbn = params.get("isbnCode");
        String amountStr = params.get("amount");

        model.addAttribute("isbnCode", params.get("isbnCode"));
        model.addAttribute("amount", params.get("amount"));

        if (isbn == null || isbn.isBlank()) {
            model.addAttribute("errorMessage", "ISBNコードは必須です");
            return "reserveappro";
        }
        if (amountStr == null || amountStr.isBlank()) {
            model.addAttribute("errorMessage", "金額は必須です");
            return "reserveappro";
        }

        try {
            int amount = Integer.parseInt(amountStr);
            if (amount <= 0) {
                model.addAttribute("errorMessage", "金額は正の値を入力してください");
                return "reserveappro";
            }
        } catch (NumberFormatException e) {
            model.addAttribute("errorMessage", "金額の形式が不正です");
            return "reserveappro";
        }

        // DB更新
        reservationService.approve(params);

        // 承認後は注文履歴へリダイレクト
        return "redirect:/orderhistory";
    }

}
