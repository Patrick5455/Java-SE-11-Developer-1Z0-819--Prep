### Generics and Type Hierarchy

Generics are `invariant` to enforce compile-time verification of types
- Java arrays are `covariant`, which can result in runtime executions 

`Product[] products = new Food[10];`
`products[0] = new Drink ("Tea");` - compiler error: _java.lang.ArrayStoreException_

> Covariant basically means that an array of subtype is considered to be assignable to 
> a variable of an array of a supertype.
> 
Collection API uses generics `and generics are designed to be invariant`. 
> From the perspective of generics, an array list of food is not compatible with an array list
> of product even though a type of Food extends Product. The compiler will prevent you
> froom doing such assignment (below). The compiler will say a list of subtype is not the same
> as the list of a supertype

`List<Product> products = new ArrayListL<Food>();` - compiler error indicating incompatible types: _ArrayList<Food> cannot be converted to List<Product>_

- Generics compiler checks are not performed for raw types, whcih can result in 
runtime exceptions.
  
e.g the following could lean to runtime exception
`List<Food> foods = new ArrayList<Food>();
List values = foods;
List<Product> products = values;
products.add(new Drink("Tea"));
Drink x1 = (Drink) values.get(0);
Food x2 = foods.get(0);`

_@ List<Product> products = values; the compiler warns about unchecked or unsafe operations_
_@ Food x2 = foods.get(0); we get this error`java.lang.ClassCastException: class demos.Drink cannot be cast to class demos.Food`_ 


