package deitelexamples;

import java.util.Arrays;

public class Generics4Overloading {

    public static void main(String[] args) {
        Integer[] ints = {1,2,3,4};
        String[] strings = {"Hello ", "World"};
        Boolean[] booleans = {Boolean.TRUE, Boolean.FALSE};
        Character[] characters = {'h', 'e', 'r'};

        printArray(ints);
        printArray(strings);
        printArray(booleans);
        printArray(characters);

    }

    public static  <T> void printArray(T[] inputArray){
        System.out.printf("Printing content of array of type  %s%n",inputArray.getClass().getName());
        Arrays.stream(inputArray).forEach(System.out::print);
        System.out.println();
    }

}
