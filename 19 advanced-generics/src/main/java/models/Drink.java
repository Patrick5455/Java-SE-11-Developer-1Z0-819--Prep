package models;
import lombok.Data;

@Data
public class Drink extends Product {

    private String bar;
    private String brand;

    public Drink(){}

    public Drink(String bar, String brand, String name, String description) {
        super(name, description);
        this.bar = bar;
        this.brand = brand;
    }

    public Drink(String bar, String brand) {
        super();
        this.bar = bar;
        this.brand = brand;
    }
}
