package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "package")
public class Package implements Serializable {

    private static final long serialVersionUID = -5577579081128070434L;

    @Id
    @Column(name = "idPackage")
    @GeneratedValue(generator = "incrementor")
    @GenericGenerator(name = "incrementor", strategy = "increment")
    private int id;

    @Column(name = "id_sender")
    private int id_sender;

    @Column(name = "id_reciver")
    private int id_reciver;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "senderCity")
    private String senderCity;

    @Column(name = "destinationCity")
    private String destinationCity;

    @Column(name = "tracking")
    private boolean tracking;

    @Column(name = "route")
    private String route;

    public Package(int id, int id_sender, int id_reciver, String name, String description, String senderCity, String destinationCity, boolean tracking, String route) {
        this.id = id;
        this.id_sender = id_sender;
        this.id_reciver = id_reciver;
        this.name = name;
        this.description = description;
        this.senderCity = senderCity;
        this.destinationCity = destinationCity;
        this.tracking = tracking;
        this.route = route;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_sender() {
        return id_sender;
    }

    public void setId_sender(int id_sender) {
        this.id_sender = id_sender;
    }

    public int getId_reciver() {
        return id_reciver;
    }

    public void setId_reciver(int id_reciver) {
        this.id_reciver = id_reciver;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSenderCity() {
        return senderCity;
    }

    public void setSenderCity(String senderCity) {
        this.senderCity = senderCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public boolean isTracking() {
        return tracking;
    }

    public void setTracking(boolean tracking) {
        this.tracking = tracking;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "Package{" +
                "id=" + id +
                ", id_sender=" + id_sender +
                ", id_reciver=" + id_reciver +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", senderCity='" + senderCity + '\'' +
                ", destinationCity='" + destinationCity + '\'' +
                ", tracking=" + tracking +
                ", route=" + route +
                '}';
    }
}
