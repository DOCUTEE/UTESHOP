package ktweb.uteshop.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
@PrimaryKeyJoinColumn(name = "customerId")

public class Customer extends User{
    @OneToMany(mappedBy = "customer")
    private List<Question> questions;

    public static void main(String[] args) {

    }

}
