package jp.te4a.teamc.spring.boot.bookapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import jp.te4a.teamc.spring.boot.bookapp.service.ReservationService;
import jp.te4a.teamc.spring.boot.bookapp.bean.Reservation;

@Controller
public class OrderController {

    @Autowired
    private ReservationService reservationService;

    // 注文受付画面を表示（一覧をモデルに渡す）
    /*@GetMapping("/orderhistory")
    public String showOrders(Model model) {
        List<Reservation> reservationList = reservationService.findAll();
        model.addAttribute("reservationList", reservationList);
        return "orderhistory"; // orderReception.htmlを表示
    }*/

    // 承認ボタン押下時の処理
    @PostMapping("/reserveappro")
    public String approve(@RequestParam Map<String, String> params) {
        // ここで承認処理を実施
        reservationService.approve(params);

        // 承認日時と承認状態をパラメータで渡したいなら、サービスの戻り値等で受け取って
        // リダイレクトURLに付加してもOK。簡単ならリダイレクト先は一覧画面だけでも良い。
        return "redirect:/orderReception";
    }

    // 取引完了ボタン押下時の処理
    @PostMapping("/complete")
    public String complete(@RequestParam Map<String, String> params) {
        reservationService.complete(params);
        return "redirect:/orderReception";
    }

    // 過去のコード：承認状態をURLパラメータでorderhistoryに渡す例
    // 必要であれば使うが、基本はリダイレクト先でDBやサービスから状態を取得したほうが良い
    /*
    @PostMapping("/reserveapproOld")
    public String approveReservation(@RequestParam("title") String title,
            @RequestParam("publisher") String publisher,
            @RequestParam("count") String count,
            @RequestParam("name") String name,
            @RequestParam("ISBNcode") String isbnCode,
            @RequestParam("amount") String amount) {

        String approvalStatus = "承認済み";
        String approvalDate = LocalDate.now().toString();

        String redirectUrl = String.format(
                "redirect:/orderhistory?title=%s&publisher=%s&count=%s&name=%s&ISBNcode=%s&amount=%s&approvalStatus=%s&approvalDate=%s",
                URLEncoder.encode(title, StandardCharsets.UTF_8),
                URLEncoder.encode(publisher, StandardCharsets.UTF_8),
                URLEncoder.encode(count, StandardCharsets.UTF_8),
                URLEncoder.encode(name, StandardCharsets.UTF_8),
                URLEncoder.encode(isbnCode, StandardCharsets.UTF_8),
                URLEncoder.encode(amount, StandardCharsets.UTF_8),
                URLEncoder.encode(approvalStatus, StandardCharsets.UTF_8),
                URLEncoder.encode(approvalDate, StandardCharsets.UTF_8));

        return redirectUrl;
    }
    */

    // orderhistory画面表示例（必要なら）
    /*
    @GetMapping("/orderhistory")
    public String orderHistory(@RequestParam(required = false) String title,
                               @RequestParam(required = false) String publisher,
                               @RequestParam(required = false) String count,
                               @RequestParam(required = false) String name,
                               @RequestParam(required = false) String ISBNcode,
                               @RequestParam(required = false) String amount,
                               @RequestParam(required = false) String approvalStatus,
                               @RequestParam(required = false) String approvalDate,
                               Model model) {

        model.addAttribute("title", title);
        model.addAttribute("publisher", publisher);
        model.addAttribute("count", count);
        model.addAttribute("name", name);
        model.addAttribute("ISBNcode", ISBNcode);
        model.addAttribute("amount", amount);
        model.addAttribute("approvalStatus", approvalStatus);
        model.addAttribute("approvalDate", approvalDate);

        return "OrderHistory";
    }
    */
}
