package ktweb.uteshop.entity;

import cnpm.ergo.configs.JPAConfig;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Message")
@NamedQuery(name = "Message.findAll", query = "SELECT c FROM Message c")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "messsageId")
    private int messageId;
    @Column(name = "content", columnDefinition = "TEXT")
    private String content;
    @Column(name = "timestamp", columnDefinition = "DATETIME")
    private Date timestamp;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User sender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "conversationId", referencedColumnName = "conversationId")
    private Conversation conversation;

    public static void main(String[] args) {

    }

}