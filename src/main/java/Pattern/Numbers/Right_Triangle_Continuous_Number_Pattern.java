package Pattern.Numbers;

public class Right_Triangle_Continuous_Number_Pattern {

    public static void printNums(int n) {

        int i, j, num = 1;

        for (i = 0; i < n; i++) {
            for (j = 0; j <= i; j++) {
                System.out.print(num + " ");
                num = num + 1;
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int n = 5;
        printNums(n);
    }

}
