package be.intecbrussel.jdbcdemo.model;

import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(appliesTo = "brewers")
public class Brewers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Name;
    private String Address;
    private int ZipCode;
    private String City;
    private int Turnover;

    @OneToMany(mappedBy = "Brewers", fetch = FetchType.EAGER)
    private List<Beer> beerList;

    public Brewers(String name, String address, int zipCode, String city, int turnover) {
        this.Name = name;
        this.Address = address;
        this.ZipCode = zipCode;
        this.City = city;
        this.Turnover = turnover;
    }

    public Brewers() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getZipCode() {
        return ZipCode;
    }

    public void setZipCode(int zipCode) {
        ZipCode = zipCode;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public int getTurnover() {
        return Turnover;
    }

    public void setTurnover(int turnover) {
        Turnover = turnover;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    public int getId() {
        return id;
    }
}
