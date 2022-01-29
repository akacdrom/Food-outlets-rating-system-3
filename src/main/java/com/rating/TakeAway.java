package com.rating;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "et_take_away")
@Table(name = "et_take_away")
public class TakeAway extends Outlet{

    public TakeAway() {
    }

    /* Class TakeAway is extended by Restaurant
    *  No overrides or additional enhancements have been made yet for this class*/
    public TakeAway(String name, String rating, String price, String hours, String city) {
        super(name, rating, price, hours, city);
    }
    public TakeAway(String name, String rating, String filePath) {
        super(name, rating, filePath);
    }

    public TakeAway(String filePath) {
        super(filePath);
    }

}
