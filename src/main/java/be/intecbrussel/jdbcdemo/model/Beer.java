package be.intecbrussel.jdbcdemo.model;

import javax.persistence.*;
import java.util.Objects;
@Entity
@Table(name = "Beers")
public class Beer {
@Id
    private int id;
@Column(name = "Name")
    private String beerName;
@Column(name = "Alcoholpercentage")
    private double alcoholPercentage;
@Column(name = "Price")
    private double price;
@Column(name ="Stock")
    private int stock;
@ManyToOne
@JoinColumn(name = "BrewerId")
    private Brewers brewers;


    public Beer() {
    }

    public Beer(String beerName, double alcoholPercentage, double price, int stock) {
        this.beerName = beerName;
        this.alcoholPercentage = alcoholPercentage;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBeerName() {
        return beerName;
    }

    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }

    public double getAlcoholPercentage() {
        return alcoholPercentage;
    }

    public void setAlcoholPercentage(double alcoholPercentage) {
        this.alcoholPercentage = alcoholPercentage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    @Override
    public String toString(){
        return " Beer with: id:" +id +", Beername = " + beerName+", Alcoholprecentage = "+ alcoholPercentage
                + ", Price = " + price + ", Stock = " +stock;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beer beer = (Beer) o;
        return Double.compare(beer.alcoholPercentage, alcoholPercentage) == 0 &&
                Double.compare(beer.price, price) == 0 &&
                stock == beer.stock &&
                Objects.equals(beerName, beer.beerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beerName, alcoholPercentage, price, stock);
    }
}
