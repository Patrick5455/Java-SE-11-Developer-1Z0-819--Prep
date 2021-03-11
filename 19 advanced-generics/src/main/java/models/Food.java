package models;

import lombok.Data;

@Data
public class Food extends Product{


    private String restaurant;
    private String dishes;

    public Food(){}

    public Food(String restaurant, String dishes, String name, String description){
        super(name, description);
        this.restaurant = restaurant;
        this.dishes = dishes;
    }

    public Food(String restaurant, String dishes){
        super();
        this.restaurant = restaurant;
        this.dishes = dishes;
    }
}
