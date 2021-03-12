## Generics and Type Hierarchy

#### Generics are `invariant` to enforce compile-time verification of types
#### Java arrays are `covariant`, which can result in runtime executions 

`Product[] products = new Food[10];`
`products[0] = new Drink ("Tea");` - _compiler error: `java.lang.ArrayStoreException`_

> Covariant basically means that an array of subtype is considered to be assignable to 
> a variable of an array of a supertype.
> 
Collection API uses generics `and generics are designed to be invariant`. 
> From the perspective of generics, an array list of food is not compatible with an array list
> of product even though a type of Food extends Product. The compiler will prevent you
> froom doing such assignment (below). The compiler will say a list of subtype is not the same
> as the list of a supertype

`List<Product> products = new ArrayListL<Food>();` - _compiler error indicating incompatible types: `ArrayList<Food> cannot be converted to List<Product>`_

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

#### WildCard Generics `<?>`
Generics are used to enforce compile-time verification of a type.
Generics are often used with Collection API. Consider the ffg collection examples:

- When `generics are not applied`, code defaults to use type Object.
     - Only Object class operation can be safely used.
     - Type-check and type-casting must be applied to access any sub-type specific operations.

- When `specific type is applied`:
     - Any operations declared for this type or its parents can be safely used.
     - Type-check and type-casting must be applied to access any sub-type specific operations
    
- When `wildcard <?> is applied (representing an unknown type)`: 
    - Elements are accessed just like in a collection of Objects
    - Effectively it's a read-only collection e.g __List<?> listOfUnknownType = listOfProducts__
    - No object in Java is of unknown type, so no values (except null) can be added to such a collection    
    
     
#### Upper Bound Wildcard

Upper bounded wildcard `<? extends ParentType>` allows use of subtype collections.

- A list of specific type List<Product>
    - Is writable - you can add instances of `Product, Food and Drink` to such a list
    - Is invariant - you cannot assign a `List<Drink> or List<Food>` to such a list

- A list of super type and descendants `List<? extands Product>`
    - Is _read only_ - no values (except null) can be added to such a list
    - is _covariant_ - you can assign a `List<Drink> or List<Food>` to such a list
    
e.g

> public void setProducts(List<Product> products)  {}
> public void setProductAndSubTypes (List<? extends Product> products) {}


List<? extends Product> products : 
    - List<Product>
    - List<Drink>
    - List<Food>


#### Lower Bound Wildcard
Lower bounded wildcard `<? super Type>` allows to use this type and its parents.
- A list of specific type List<Food>
    - is _invariant_ - you can only assign a `List<Food>` to such a list

- A list of type and its parents `List<? super Food>`
    - Is _writable_ - you can add instances of `Object, Product and Food` to such a list
    - Is _contra-variant_ - you can assign a `List<Food>` or `List<Product>` or `List<Object>` to such a list
    
> public void addFoodToFoods (List<Food> order, Food food){
>   order.add(food)
> }

The method above will only allow use a type of `List<Food>` even `List<Product>` 
will not be allowed because it is invariant

> public void addFoodToFoodParents(List<? super Food> order, Food food){
>   order.add(food)
> }

The method aboce will allow to use any list with type that is a super class of Food 
e.g `List<Object> or List<Product> & List<Food> itself` Any List with types asides the super class types 
e.g `List<Drink>`will lead to compiler error.

#### Been able to assign any of the sub types using `<? extends SuperType>`or super types using `<? super Type>` is known as `contra-variant` behaviour



