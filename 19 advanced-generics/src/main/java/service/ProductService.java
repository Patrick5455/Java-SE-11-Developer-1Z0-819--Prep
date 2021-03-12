package service;

import lombok.Data;
import models.Drink;
import models.Food;
import models.Product;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductService {



    // singleton
    private ProductService(){}
    private static final ProductService INSTANCE = new ProductService();
    public static ProductService getProductService(){return INSTANCE;}


    List<? extends Product> productList = new ArrayList<>();
    List<? super Food> foodList = new ArrayList<>();
    List<? super Drink> drinkLIst = new ArrayList<>();


    // contravariant - anything that extends Product can be added to the list
    public void addProduct(Product product){
        productList = List.of(product); //unmodifiable list
    }

    // contravariant - anything that is is super of Food can be added to the list e.g Product or Object
    public void addFoodOrProduct(Product product){
        foodList = List.of(product);//unmodifiable list
    }

    // contravariant - anything that is is super of Drink can be added to the list e.g Product or Object
    public List<? super Drink> addDrinkOrProduct(Product product){
        drinkLIst = List.of(product);//unmodifiable list
        return drinkLIst;
    }


}
