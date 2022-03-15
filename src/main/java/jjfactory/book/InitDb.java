//package jjfactory.book;
//
//import jjfactory.book.model.*;
//import jjfactory.book.model.item.Book;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.annotation.PostConstruct;
//import javax.persistence.EntityManager;
//
//@RequiredArgsConstructor
//@Component
//public class InitDb {
//
//    @Transactional
//    @Component
//    @RequiredArgsConstructor
//    static class InitService{
//
//        private final InitService initService;
//
//        @PostConstruct
//        public void init(){
//            initService.dbInit();
//        }
//
//        private final EntityManager em;
//        public void dbInit(){
//            Member member = new Member();
//            member.setName("userA");
//            member.setAddress(new Address("city1","zipcode1"));
//            em.persist(member);
//
//            Book book1 = new Book();
//            book1.setName("book 1");
//            book1.setPrice(10000);
//            em.persist(book1);
//
//            Book book2 = new Book();
//            book2.setName("book 2");
//            book2.setPrice(20000);
//            em.persist(book2);
//
//            OrderItem orderItem1 = OrderItem.createOrderItem(book1, 10000, 1);
//            OrderItem orderItem2 = OrderItem.createOrderItem(book2, 20000, 3);
//
//            Delivery delivery = new Delivery();
//            delivery.setAddress(member.getAddress());
//            Order.createOrder(member,delivery,orderItem1,orderItem2);
//        }
//
//    }
//}


