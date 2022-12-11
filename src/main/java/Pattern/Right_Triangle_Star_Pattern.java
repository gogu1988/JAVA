package Pattern;

public class Right_Triangle_Star_Pattern {

    public static void StarRightTriangle(int n) {
        for (int a = 0; a < n; a++) {
            for (int b = 0; b <= a; b++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int k = 5;
        StarRightTriangle(k);
    }
}
