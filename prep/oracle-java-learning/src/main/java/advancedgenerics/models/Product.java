package advancedgenerics.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class Product {

    private String name;
    private String description;

    public Product(){}

    public Product(String name, String description){
        this.name = name;
        this.description = description;
    }




}
