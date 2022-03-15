package jjfactory.book.repository;

import jjfactory.book.model.Order;
import jjfactory.book.model.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Long> {

    @Query("select i from Item i where i.name= :name and i.price = :price")
    List<Item> findItem(@Param("name") String name, @Param("price") int price);
}
