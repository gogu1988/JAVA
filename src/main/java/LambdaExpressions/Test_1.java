package LambdaExpressions;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Test_1 {
    public static void main(String args[])
    {
        // Creating an ArrayList with elements
        // {1, 2, 3, 4}
        ArrayList<Integer> arrL = new ArrayList<Integer>();
        arrL.add(11);
        arrL.add(22);
        arrL.add(33);
        arrL.add(44);

        // Using lambda expression to print all elements
        // of arrL
        arrL.forEach(n -> System.out.println(n));

        // Using lambda expression to print even elements
        // of arrL
        Consumer<Integer> c = n->{
            System.out.println(n*n);
        };
        arrL.forEach(c);
        System.out.println(arrL);
    }
}
