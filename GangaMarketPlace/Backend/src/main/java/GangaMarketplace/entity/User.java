package GangaMarketplace.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;

    @Column(name = "telephone_number")
    private String telephoneNumber;

    private String email;
    private String userName;
    private String password;

    public User(Long id, String name, String address, String telephoneNumber, String email, String userName, String password) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public User() {}
}