package jp.te4a.teamc.spring.boot.bookapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "Login";  // Login.htmlを表示
    }
    @GetMapping("/order-history")
    public String showOrderHistory() {
        return "OrderHistory"; // OrderHistory.html を表示
    }
    @GetMapping("/loginForm")
    public String showLoginForm(@RequestParam(value = "error", required = false) String error,
                                @RequestParam(value = "logout", required = false) String logout,
                                Model model) {
        if (error != null) model.addAttribute("errorMessage", "ユーザIDかパスワードが違います");
        if (logout != null) model.addAttribute("logoutMessage", "ログアウトしました");
        return "Login"; // Login.html
    }
    @GetMapping("/bookreservation")
    public String showReservationForm() {
    return "BookReservation";  // Reservation.html を返す
    }


    @PostMapping("/login")
String login(@RequestParam String user, @RequestParam String password, Model model) {
    // ユーザーIDとパスワードが両方空文字なら予約画面へ
    if (user.isEmpty() && password.isEmpty()) {
        return "redirect:/bookreservation";
    }

    // 仮の認証処理
    if ("admin".equals(user) && "admin".equals(password)) {
        return "redirect:/order-history";
    }

    // 認証失敗
    model.addAttribute("errorMessage", "ユーザIDかパスワードが違います");
    return "Login";
}
}

