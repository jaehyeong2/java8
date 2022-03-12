package jjfactory.book.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String street;
    private String zipcode;
}
