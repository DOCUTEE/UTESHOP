package ktweb.uteshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Review")
@NamedQuery(name = "Review.findAll", query = "SELECT r FROM Review r")
public class Review {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "reviewId")
    private int reviewId;

    @Column(name = "content") 
    private String content;

    @Column(name = "createAt", nullable = false)
    private LocalDateTime createAt; 

    @Column(name = "rating",nullable = false)
    private double rating; 

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product product; 

    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;
}
