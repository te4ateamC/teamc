package jp.te4a.teamc.spring.boot.bookapp.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @WebServlet("/logout")
    public class LogoutServlet extends HttpServlet {
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            request.getSession().invalidate(); // セッション削除
            response.sendRedirect("Login.html"); // Login画面にリダイレクト
        }
    }

    @GetMapping("/loginForm")
    public String showLoginForm(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            Model model) {
        if (error != null)
            model.addAttribute("errorMessage", "ユーザIDかパスワードが違います");
        if (logout != null)
            model.addAttribute("logoutMessage", "ログアウトしました");
        return "Login"; // Login.html
    }

    @GetMapping("/bookreservation")
    public String showReservationForm() {
        return "BookReservation"; // Reservation.html を返す
    }

    @PostMapping("/login")
    String login(@RequestParam String user, @RequestParam String password, Model model) {
        // ユーザーIDとパスワードが両方空文字なら予約画面へ
        if (user.isEmpty() && password.isEmpty()) {
            return "redirect:/bookreservation";
        }

        // 仮の認証処理
        if ("admin".equals(user) && "admin".equals(password)) {
            return "redirect:/orderhistory";
        }

        // 認証失敗
        model.addAttribute("errorMessage", "ユーザIDかパスワードが違います");
        return "Login";
    }
}
