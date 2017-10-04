package fr.wcs.blablacrade;

import java.util.Date;

/**
 * Created by wilder on 13/09/17.
 */

public class TripResultModel {

    private Date departure;
    private String name;
    private int price;

    public TripResultModel(String name, Date departure, int price) {

        this.name = name;
        this.departure = departure;
        this.price = price;
    }


    public Date getDeparture() {
        return departure;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
