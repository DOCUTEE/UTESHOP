package ktweb.uteshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "cart")
@NamedQuery(name = "Cart.findAll", query = "SELECT c FROM Cart c")
public class Cart {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartId")
    private int cartId;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private Customer customer;
    
    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER)
    private List<CartItem> cartItems;

}
