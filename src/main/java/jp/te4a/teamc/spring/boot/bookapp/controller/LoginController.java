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

    @PostMapping("/login")
    String login(@RequestParam String user, @RequestParam String password, Model model) {
        // 仮の認証処理
        if ("admin".equals(user) && "admin".equals(password)) {
            return "redirect:/books";  // 認証成功したら本一覧へリダイレクト
        }
        // 認証失敗したらエラーメッセージをセットしてログインフォームに戻る
        model.addAttribute("errorMessage", "ユーザIDかパスワードが違います");
        return "Login";
    }
}
