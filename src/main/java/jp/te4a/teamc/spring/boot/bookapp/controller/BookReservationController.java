package jp.te4a.teamc.spring.boot.bookapp.controller;

import jp.te4a.teamc.spring.boot.bookapp.service.BookReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookReservationController {

    @Autowired
    private BookReservationService reservationService;

   @GetMapping("/reservation")
    public String showLoginForm() {
        return "BookReservation";  // BookReservation.htmlを表示
    }
    @PostMapping("/post")
    public String reserveBook(
        @RequestParam String title,
        @RequestParam String publisher,
        @RequestParam String count,
        @RequestParam String name,
        @RequestParam String tel,
        @RequestParam String email,
        @RequestParam(required = false) String address,
        Model model
    ) {
        // 画面に表示する内容
        model.addAttribute("title", title);
        model.addAttribute("publisher", publisher);
        model.addAttribute("count", count);
        model.addAttribute("name", name);
        model.addAttribute("tel", tel);
        model.addAttribute("email", email);

        // Serviceに予約処理を任せる
        reservationService.reserve(title, publisher, count, name, tel, email);

        return "Confirmation";  // Confirmation.htmlへ
    }
    @PostMapping("/back")
    public String backToHome() {
        return "redirect:/HomePage";  // ホームページにリダイレクト
    }
    
}

