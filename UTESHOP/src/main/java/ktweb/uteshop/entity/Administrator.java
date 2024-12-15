package ktweb.uteshop.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Administrator")
@NamedQuery(name = "Administrator.findAll", query = "SELECT e FROM Administrator e where e.isDelete = false")

public abstract class Administrator implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AdministratorId")
    private int AdministratorId;

    @Column(name = "name", length = 100, unique = true)
    private String name;

    @Column(name = "email", length = 100, unique = true)
    private String email;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "phone", length = 100)
    private String phone;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "gender", length = 100)
    private String gender;

    @Column(name = "status", length = 100)
    private String status;

    @Column(name = "isDelete", columnDefinition = "BIT")
    private Boolean isDelete;


}

