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
@Table(name = "product")
@NamedQuery(name = "product.findAll", query = "SELECT p FROM Product p")
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private int productId;
    @Column(name = "name", columnDefinition = "NVARCHAR(200) NOT NULL")
    private String name;

    @Column(name = "descript", columnDefinition = "TEXT")
    private String descript;

    @Column(name = "isDelete", columnDefinition = "BIT")
    private boolean isDelete;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProductType> productTypes;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProductImage> productImages;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
    private Category category;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Wishlist> wishlists;
}