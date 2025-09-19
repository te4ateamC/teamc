package jp.te4a.teamc.spring.boot.bookapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
    @GetMapping("/HomePage")
    public String homePage() {
        return "HomePage"; // HomePage.html を返す
    }
}
