import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Demo extends Thread{

    static CopyOnWriteArrayList <Integer> list = new CopyOnWriteArrayList <>();

    public void run(){
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        list.add(15);
    }

    public static void main(String[] args) throws InterruptedException {
        list.add(1);
        list.add(2);
        list.add(7);
        list.add(4);
        list.add(5);
        System.out.println(list);

        Demo d = new Demo();
        d.start();

        Iterator i = list.iterator();

        while(i.hasNext()){
            Integer x = (Integer)i.next();
            Thread.sleep(3000);
        }

        System.out.println(list);

    }
}
