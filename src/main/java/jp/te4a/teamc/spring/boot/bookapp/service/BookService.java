package jp.te4a.teamc.spring.boot.bookapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.te4a.teamc.spring.boot.bookapp.bean.OrderBean;
import jp.te4a.teamc.spring.boot.bookapp.form.BookForm;
import jp.te4a.teamc.spring.boot.bookapp.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public BookForm create(BookForm bookForm) {
        OrderBean bookBean = new OrderBean();
        BeanUtils.copyProperties(bookForm, bookBean);
        bookRepository.save(bookBean);
        return bookForm;
    }

    public BookForm update(BookForm bookForm) {
        OrderBean bookBean = new OrderBean();
        BeanUtils.copyProperties(bookForm, bookBean);
        bookRepository.save(bookBean);
        return bookForm;
    }

    public void delete(String id) {
        bookRepository.deleteById(id);
    }

    public List<BookForm> findAll() {
        List<OrderBean> beanList = bookRepository.findAll();
        List<BookForm> formList = new ArrayList<BookForm>();
        for (OrderBean bookBean : beanList) {
            BookForm bookForm = new BookForm();
            BeanUtils.copyProperties(bookBean, bookForm);
            formList.add(bookForm);
        }
        return formList;
    }

    public BookForm findOne(String id) {
        BookForm bookForm = new BookForm();
        bookRepository.findById(id).ifPresent(bookBean -> {
            BeanUtils.copyProperties(bookBean, bookForm);
        });
        return bookForm;
    }

    public BookForm save(BookForm bookForm) {
        OrderBean bookBean = new OrderBean();
        BeanUtils.copyProperties(bookForm, bookBean);
        bookRepository.save(bookBean);
        return bookForm;
    }
}
