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
    public String processApproval(@RequestParam Map<String, String> params, Model model) {
        // 画面表示用データ
        model.addAttribute("title", params.get("title"));
        model.addAttribute("publisher", params.get("publisher"));
        model.addAttribute("count", params.get("count"));
        model.addAttribute("name", params.get("name"));
    
        String amountStr = params.get("amount");
    
        // 承認処理用フラグを追加（JSで送る hidden）
        String submitFlag = params.get("submit"); // 例えば hidden name="submit" value="true"
    
        if (submitFlag == null) {
            // 画面表示だけ → エラーは出さない
            return "reserveappro";
        }
    
        // 金額チェック
        if (amountStr == null || amountStr.isEmpty()) {
            model.addAttribute("errorMessage", "金額は必須です");
            return "reserveappro";
        }
    
        try {
            double amount = Double.parseDouble(amountStr);
            if (amount <= 0) {
                model.addAttribute("errorMessage", "金額は正の値でなければなりません");
                return "reserveappro";
            }
        } catch (NumberFormatException e) {
            model.addAttribute("errorMessage", "金額の形式が不正です");
            return "reserveappro";
        }
    
        // 冊数チェック（必要なら）
        String countStr = params.get("count");
        if (countStr != null) {
            try {
                int count = Integer.parseInt(countStr);
                if (count <= 0) {
                    model.addAttribute("errorMessage", "冊数は正の整数でなければなりません");
                    return "reserveappro";
                }
            } catch (NumberFormatException e) {
                model.addAttribute("errorMessage", "冊数の形式が不正です");
                return "reserveappro";
            }
        }
    
        // DB更新など
        reservationService.approve(params);
    
        return "redirect:/orderhistory";
    }
    
}
