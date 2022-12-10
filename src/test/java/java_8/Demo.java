package java_8;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Demo extends Thread{

    public static void main(String[] args) throws InterruptedException {

        CopyOnWriteArrayList <Integer> list = new CopyOnWriteArrayList <>();

        list.add(1);
        list.add(2);
        list.add(7);
        list.add(4);
        list.add(5);
        System.out.println(list);

        Iterator i = list.iterator();

        while(i.hasNext()){
            Integer x = (Integer)i.next();

        }

        System.out.println(list);

    }
}
