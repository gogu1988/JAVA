package comparable;

import java.util.Arrays;

public class Student_2 implements Comparable<Student_2> {

    String x;
    int y;

    public Student_2(String x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public String toString()
    {
        return "(" + x + "," + y + ")";
    }

    @Override public int compareTo(Student_2 a)
    {
        // if the string are not equal
        if (this.x.compareTo(a.x) != 0) {
            return -this.x.compareTo(a.x);
        }
        else {
            // we compare int values
            // if the strings are equal
            return -(this.y - a.y);
        }
    }

    public static void main(String[] args)
    {

        int n = 4;
        Student_2 arr[] = new Student_2[4];

        arr[0] = new Student_2("abc", 3);
        arr[1] = new Student_2("a", 4);
        arr[2] = new Student_2("bc", 5);
        arr[3] = new Student_2("a", 2);

        // Sorting the array
        Arrays.sort(arr);

        // printing the
        // Pair array
        print(arr);
    }

    public static void print(Student_2[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
