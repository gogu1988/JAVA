package comp;

import java.util.ArrayList;
import java.util.Collections;

public class Student implements Comparable<Student> {

    int id;
    String name;
    char grade;

    Student(int id, String name, char grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    @Override
    public int compareTo(Student st) {
        if (id == st.id)
            return 0;
        else if (id < st.id)
            return -2;
        else
            return 3;
    }

    public static void main(String args[]){
        ArrayList<Student> al=new ArrayList<Student>();
        al.add(new Student(106,"Vijay",'c'));
        al.add(new Student(101,"Ajay",'a'));
        al.add(new Student(105,"Jai",'b'));
        al.add(new Student(103,"Jai",'b'));
        al.add(new Student(104,"Jai",'b'));

        Collections.sort(al);
        for(Student st:al){
            System.out.println(st.id+" "+st.name+" "+st.grade);
        }
    }
}
