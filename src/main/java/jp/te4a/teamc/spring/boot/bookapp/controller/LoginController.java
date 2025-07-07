package jp.te4a.teamc.spring.boot.bookapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
@Controller
public class LoginController {
    @GetMapping(path = "loginForm")
    String loginForm() {
        return "loginForm";
    }
}
*/

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping(path = "login")
    public String showLoginForm() {
        return "Login";  // Login.jspを表示
    }

    @PostMapping(path = "post")
    String login(@RequestParam String user, @RequestParam String password, Model model) {
        // 仮の認証処理
        if ("admin".equals(user) && "admin".equals(password)) {
            return "redirect:/books";  // 認証成功したら本一覧へリダイレクト
        }
        // 認証失敗したらエラーメッセージをセットしてログインフォームに戻る
        model.addAttribute("errorMessage", "ユーザIDかパスワードが違います");
        return "loginForm";
    }
}
