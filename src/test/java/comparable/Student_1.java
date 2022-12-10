package comparable;

import java.util.ArrayList;
import java.util.Collections;

public class Student_1 implements Comparable<Student_1> {

    int id;
    String name;
    char grade;

    Student_1(int id, String name, char grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    @Override
    public int compareTo(Student_1 st) {
        return -name.compareTo(st.name);
    }

    public static void main(String args[]){
        ArrayList<Student_1> al=new ArrayList<Student_1>();
        al.add(new Student_1(101,"Vijay",'c'));
        al.add(new Student_1(106,"Ajay",'a'));
        al.add(new Student_1(105,"Jai",'b'));

        Collections.sort(al);
        for(Student_1 st:al){
            System.out.println(st.id+" "+st.name+" "+st.grade);
        }
    }
}
