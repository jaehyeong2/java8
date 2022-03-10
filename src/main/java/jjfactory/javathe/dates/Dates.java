package jjfactory.javathe.dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Dates {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println("date = " + date);

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate = " + localDate);
        System.out.println("localDateTime = " + localDateTime);

        int[] array = {1,2,34,5};

    }
}
