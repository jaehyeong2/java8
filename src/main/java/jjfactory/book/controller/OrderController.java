package jjfactory.book.controller;

import jjfactory.book.model.Order;
import jjfactory.book.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/order")
    public String orderForm(){
        return "orderForm";
    }

    @PostMapping("/order")
    public ResponseEntity<?> orderSave(Order order){
        orderService.save(order);
        return new ResponseEntity<>("ORDER",HttpStatus.OK);
    }
}
