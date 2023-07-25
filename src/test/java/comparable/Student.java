package comparable;

import java.util.*;

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
            return 2;
        else
            return -3;
    }

    public static void main(String args[]){

        HashSet
        ArrayList<Student> al=new ArrayList<Student>();
        al.add(new Student(106,"Vijay",'c'));
        al.add(new Student(101,"Ajay",'a'));
        al.add(new Student(105,"Jai",'b'));

        Collections.sort(al);
        for(Student st:al){
            System.out.println(st.id+" "+st.name+" "+st.grade);
        }
    }
}
