package Pattern.Star;

public class Down_Triangle {

    public static void printReverseTriangle(int n) {

        for (int i = n; i > 0; i--) {

            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    public static void main(String args[]) {
        int n = 5;
        printReverseTriangle(n);
    }

}
