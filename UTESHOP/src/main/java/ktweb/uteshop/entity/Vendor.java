package ktweb.uteshop.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.util.List;
@Entity
@NamedQuery(name = "Vendor.findAll", query = "SELECT e FROM Vendor e where e.isDelete = false")
@PrimaryKeyJoinColumn(name = "vendorId")

public class Vendor extends User{
    @OneToMany(mappedBy = "Vendor")
    private List<Conversation> conversations;
}
