package com.rating;

import javax.persistence.*;

//@Entity(name = "et_restaurant")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public class Outlet {
    @Id
    /* IDENTITY is used because I used SERIAL in postgreSQL database. */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "rating")
    private String rating;

    @Column(name = "range")
    private String price;

    @Column(name = "hours")
    private String hours;

    @Column(name = "city")
    private String city;

    public Outlet() {
        super();
    }
    /* Constructor for add new outlet*/
    public Outlet(String name, String rating,String price, String hours, String city){
        this.name = name;
        this.rating = rating;
        this.price = price;
        this.hours = hours;
        this.city = city;
    }

    /* Constructor for add new rating to the selected outlet*/
    public Outlet(String name, String rating, String city){
        this.name = name;
        this.rating = rating;
        this.city = city;
    }

    /* Constructor for printing the selected outlet with rating calculations*/
    public Outlet(String city){
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

