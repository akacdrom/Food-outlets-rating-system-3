package com.rating;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "et_bistro")
@Table(name = "et_bistro")
public class Bistro extends Outlet{

    public Bistro() {
    }

    /* Class Bistro is extended by Restaurant
     *  No overrides or additional enhancements have been made yet for this class*/
    public Bistro(String name, String rating, String price, String hours, String city) {
        super(name, rating, price, hours, city);
    }
}
