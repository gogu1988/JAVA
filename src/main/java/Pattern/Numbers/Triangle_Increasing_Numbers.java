package Pattern.Numbers;

public class Triangle_Increasing_Numbers {

    public static void main(String[] args) {
        int r = 5;
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j<=r-i; j++)
                System.out.print(" ");
            for (int j = 1; j <=2*i-1 ; j++)
                System.out.print(i);
            System.out.println(" ");
        }
    }

}
