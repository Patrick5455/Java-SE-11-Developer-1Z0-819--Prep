import models.Drink;
import models.Food;
import models.Product;
import service.ProductService;

import java.util.List;

public class ProductApplication{

    public static void main(String[] args) {

        Product product = new Product();
        Food food = new Food();
        Drink drink = new Drink();



        ProductService productService = ProductService.getProductService();

        productService.addProduct(product);
        productService.addProduct(drink);
        productService.addProduct(food);
//        productService.getProductList()
//                .forEach(System.out::println);


      productService.addFoodOrProduct(food);
      productService.addProduct(drink);
      productService.addProduct(product);

      productService.getFoodList()
              .forEach(System.out::println);

       System.out.println(productService);

    }
}
