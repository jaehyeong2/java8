package jjfactory.book.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String street;
    private String zipcode;

    public Address() {
    }

    public Address(String street, String zipcode) {
        this.street = street;
        this.zipcode = zipcode;
    }
}
