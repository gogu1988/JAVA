package java_8;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.queue.SynchronizedQueue;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.Function;

class FunctionalInterface extends Object implements Cloneable {

    public static void main(String[] args) {
        ArrayList l = new ArrayList();
        l.add(1);
        l.add("Apple");

        Iterator itr = l.iterator();
//        l.add("D");
        System.out.println("hello");
//        itr.next();
        System.out.println(itr.next());
        System.out.println(l);
        System.out.println("Test");


    }

    FunctionalInterface() {

    }

//    Function

//    default int x = 10;

    void m1() {

    }


}
