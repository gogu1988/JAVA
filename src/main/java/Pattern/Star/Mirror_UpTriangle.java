package Pattern.Star;

public class Mirror_UpTriangle {

    public static void printTriangle(int n) {

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - i-1; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

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
        printTriangle(n);
        printReverseTriangle(n);
    }

}
