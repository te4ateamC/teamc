/*package jp.te4a.teamc.spring.boot.bookapp.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.te4a.teamc.spring.boot.bookapp.form.BookForm;
import jp.te4a.teamc.spring.boot.bookapp.service.BookService;

@Controller

@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;

    @ModelAttribute
    BookForm setUpForm() {
        return new BookForm();
    }

    @GetMapping
    String list(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books/list";
    }

    @PostMapping(path = "create")
    String create(@Validated BookForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return list(model);
        }
        bookService.save(form);
        return "redirect:/books";
    }

    @PostMapping(path = "edit", params = "form")
    String editForm(@RequestParam Integer id, BookForm form) {
        BookForm bookForm = bookService.findOne(id);
        BeanUtils.copyProperties(bookForm, form);
        return "books/edit";
    }

    @PostMapping(path = "edit")
    String edit(@RequestParam Integer id, @Validated BookForm form, BindingResult result) {
        if (result.hasErrors()) {
            return editForm(id, form);
        }
        bookService.update(form);
        return "redirect:/books";
    }

    @PostMapping(path = "delete")
    String delete(@RequestParam Integer id) {
        bookService.delete(id);
        return "redirect:/books";
    }

    @PostMapping(path = "edit", params = "goToTop")
    String goToTop() {
        return "redirect:/books";
    }
}
*/

package jp.te4a.teamc.spring.boot.bookapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookReservationController {

    @PostMapping("/post")
    public String reserveBook(
        @RequestParam String title,
        @RequestParam String publisher,
        @RequestParam String count,
        @RequestParam String name,
        @RequestParam String tel,
        @RequestParam(required = false) String address,
        Model model
    ) {
        // フォーム内容をモデルに渡す（画面に表示）
        model.addAttribute("title", title);
        model.addAttribute("publisher", publisher);
        model.addAttribute("count", count);
        model.addAttribute("name", name);
        model.addAttribute("tel", tel);
        model.addAttribute("address", address);

        // 予約完了画面へ
        return "reserveComplete";  // JSP: /WEB-INF/views/reserveComplete.jsp
    }
}
