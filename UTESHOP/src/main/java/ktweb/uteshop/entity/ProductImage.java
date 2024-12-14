package ktweb.uteshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "product_image")
@NamedQuery(name = "ProductImage.findAll", query = "SELECT p FROM ProductImage p")
public class ProductImage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productImageId")
    private int productImageId;

    @Column(name = "productImage", columnDefinition = "NVARCHAR(500) NOT NULL")
    private String productImage;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    @Override
    public String toString() {
        return "ProductImage{" +
                "id=" + productImageId +
                ", productId=" + product.getProductId() +  // Only include the product ID to avoid cyclic reference
                '}';
    }


}
