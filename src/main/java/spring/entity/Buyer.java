package spring.entity;

import javax.persistence.*;

@Entity
@Table(name = "buyers")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_buyer")
    private int idBuyer;

    @Column(name = "username")
    private String username;

    public Buyer() {
    }

    public int getIdBuyer() {
        return idBuyer;
    }

    public void setIdBuyer(int idBuyer) {
        this.idBuyer = idBuyer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "idBuyer=" + idBuyer +
                ", username='" + username + '\'' +
                '}';
    }
}