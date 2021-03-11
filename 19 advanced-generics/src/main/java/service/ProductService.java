package service;

import lombok.Data;
import models.Drink;
import models.Food;
import models.Product;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductService {

    /*****
     * Arrays are covariant
     * Generics are invariant:
     * in Generic collections, you cam only assign a collection of the type specified as variable
     * e.g
     * List<A> listA = new ArrayList<B>(); wrong : even though B is a subTYpe of A, i.e inherit from A
     * List<C> listC = new ArrayList<C> : this is correct
     *
     *
     * WildCard Generics:
     * Generics are used to enforce compile-time verification of a type.
     * Generics are often used with Collection API. Consider the following collection examples:
     *
     * When `generics are not applied`: code defaults to use type Object
     * - Only Object class operation can be safely used.
     * - Type-check and type-casting must be applied to access any sub-type specific operations
     *
     * When `specific type is applied`:
     * - Any operations declared for this type or its parents can be safely used
     * - Type-check and type-casting must be applied to access any sub-type specific operations
     *
     * When `wildcard <?> is applied`: (representing an unknown type):
     * - Elements are accessed just like in a collection of Objects
     * - Effectively it's a read-only collection
     * - No object in Java is of unkown type, so no values (except null) can be added to such a collection
     *
     *
     */


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
