package com.rating;

import javax.persistence.*;

@Entity(name = "et_restaurant")
@Table(name = "et_restaurant")

public class Restaurant extends Outlet{
    public Restaurant() {
    }
    /* Class Bistro is extended by Restaurant
     *  No overrides or additional enhancements have been made yet for this class*/
    public Restaurant(String name, String rating, String price, String hours, String city) {
        super(name, rating, price, hours, city);
    }
    public Restaurant(String name, String rating, String filePath) {
        super(name, rating, filePath);
    }

    public Restaurant(String filePath) {
        super(filePath);
    }
}
