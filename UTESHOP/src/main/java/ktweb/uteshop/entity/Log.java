package ktweb.uteshop.entity;

import cnpm.ergo.DAO.implement.UserDAOImpl;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "log")
@NamedQuery(name = "Log.findAll", query = "SELECT l FROM Log l")

public class Log implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int logId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    @Column(name = "dateLog")
    private LocalDateTime dateLog;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    public static void main(String[] args) {

    }
}
