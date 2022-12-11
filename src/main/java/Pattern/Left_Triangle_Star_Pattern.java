package Pattern;

public class Left_Triangle_Star_Pattern {

    public static void StarleftTriangle(int k) {

        for (int a = 0; a < k; a++) {

            for (int b = 0; b < 2*(k-a)-2; b++) {
                System.out.print(" ");
            }

            for (int b = 0; b <= a; b++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    public static void main(String args[]) {
        int k = 5;
        StarleftTriangle(k);
    }

}
