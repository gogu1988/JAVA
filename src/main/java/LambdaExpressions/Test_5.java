package LambdaExpressions;

import java.util.TreeSet;

public class Test_5 {

    public static void main(String[] args)
    {
        TreeSet<Integer> h =
                new TreeSet<Integer>((x2, x1) -> (x2 > x1) ?
                        -1 : (x2 < x1) ? 1 : 0);
        h.add(850);
        h.add(235);
        h.add(1080);
        h.add(15);
        h.add(5);
        System.out.println("Elements of the TreeSet after" +
                " sorting are: " + h);
    }

}
