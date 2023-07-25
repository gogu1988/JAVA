package LambdaExpressions;

interface MyInterface {

    // Method inside the interface
    void myFunction();
}

// Main class
class GFG_9 {

    // Custom initialization
    int data = 100;

    // Main driver method
    public static void main(String[] args)
    {

        // Creating object of this class
        // inside the main() method
        GFG_9 gfg = new GFG_9();

        // Creating object of interface
        // inside the main() method
        MyInterface intFace = () ->
        {
            System.out.println("Data : " + gfg.data);
            gfg.data += 50;

            System.out.println("Data : " + gfg.data);
        };

        intFace.myFunction();
        gfg.data += 20;

        System.out.println("Data : " + gfg.data);
    }
}