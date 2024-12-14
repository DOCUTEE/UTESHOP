package ktweb.uteshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "question")
@NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "questionId")
    private int questionId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private Customer customer;
    @Column(name = "content", columnDefinition = "TEXT")
    private String content;
    @Column(name = "timestamp", columnDefinition = "DATETIME")
    private Date timestamp;
    @Column(name = "isPending", columnDefinition = "BIT")
    private boolean isPending;
}