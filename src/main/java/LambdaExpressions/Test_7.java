package LambdaExpressions;

import java.util.TreeSet;

public class Test_7 {

    public static void main(String args[]){

        // Pass a reverse comparator to TreeSet() via a lambda expression
        TreeSet<String> ts=new TreeSet<String>((x2, x1) -> x1.compareTo(x2));

        // Add elements to the Treeset
        ts.add("A");
        ts.add("B");
        ts.add("C");
        ts.add("D");
        ts.add("E");
        ts.add("F");
        ts.add("G");

        //Display the elements .
        for(String element : ts)
            System.out.println(element + "");

        System.out.println();
    }

}
