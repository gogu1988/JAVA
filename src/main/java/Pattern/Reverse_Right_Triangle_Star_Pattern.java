package Pattern;

public class Reverse_Right_Triangle_Star_Pattern {

    public static void main(String[] args) {
        int n = 5;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j <2*i; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < n-i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }
}
