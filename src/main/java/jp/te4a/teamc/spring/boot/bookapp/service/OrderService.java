package jp.te4a.teamc.spring.boot.bookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.te4a.teamc.spring.boot.bookapp.bean.OrderBean;
import jp.te4a.teamc.spring.boot.bookapp.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderBean> findAll() {
        return orderRepository.findAll();
    }
}
