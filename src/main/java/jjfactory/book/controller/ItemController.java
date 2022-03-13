package jjfactory.book.controller;

import jjfactory.book.model.Order;
import jjfactory.book.model.item.Item;
import jjfactory.book.service.ItemService;
import jjfactory.book.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Controller
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/item")
    public String ItemForm(){
        return "itemForm";
    }

    @PostMapping("/item")
    public ResponseEntity<?> itemSave(@RequestBody Item item){
        itemService.save(item);
        return new ResponseEntity<>("Item",HttpStatus.OK);
    }
}

