package jjfactory.book.service;

import jjfactory.book.enums.OrderStatus;
import jjfactory.book.model.Order;
import jjfactory.book.model.item.Item;
import jjfactory.book.repository.ItemRepository;
import jjfactory.book.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional(readOnly = true)
    public List<Item> getList() {
        List<Item> all = itemRepository.findAll();
        return all;
    }

//    @Transactional(readOnly = true)
//    public Item getItem(){
//        itemRepository.findItem()
//    }

    @Transactional
    public void save(Item item){
        itemRepository.save(item);
    }
}
