package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
@NamedQueries(
        {
            @NamedQuery(name = "user.findByEmail", query = "SELECT A FROM User A where A.email LIKE :email"),
            @NamedQuery(name = "user.showAll", query = " FROM User as fl")
        })

public class User implements Serializable {

    private static final long serialVersionUID = -5577579081238070434L;
    public User() {
    }

    @Id
    @Column
    @GeneratedValue(generator = "incrementor")
    @GenericGenerator(name = "incrementor", strategy = "increment")
    private int idUser;

    @Column(name = "name")
    String name;

    @Column(name = "email")
    String email;

    @Column(name = "password")
    String password;

    @Column(name = "admin")
    String admin;

    public User(String name, String email, String password, String admin) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.admin = admin;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", admin='" + admin + '\'' +
                '}';
    }
}
