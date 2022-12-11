package Pattern;

public class Right_Triangle_Number_Pattern {

    public static void StarRightTriangle(int n) {
        for (int a = 0; a < n; a++) {
            int k =1;
            for (int b = a; b >= 0; b--) {
                System.out.print((b+1)+" ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int k = 5;
        StarRightTriangle(k);
    }
}
