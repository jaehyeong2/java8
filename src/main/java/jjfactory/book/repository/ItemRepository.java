package jjfactory.book.repository;

import jjfactory.book.model.Order;
import jjfactory.book.model.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
