package LambdaExpressions;

interface MyFunction {

    // Method inside the interface
    int func(int n);
}

// Main class
class GFG_8 {

    // Main driver method
    public static void main(String[] args)
    {

        // Custom local variable that can be captured
        int number = 10;

        MyFunction myLambda = (n) ->
        {

                   // However, the following is illegal because it
            // attempts to modify the value of number

            // number++;
            return number + n;
        };

        // The following line would also cause an error,
        // because it would remove the effectively final
        // status from num. number = 9;

        System.out.println("GFG!"+ myLambda.func(10));
    }
}