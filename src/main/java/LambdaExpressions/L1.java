package LambdaExpressions;

interface FuncInterface{

//    void absFun(int x);

    default void defaultFun(){
        System.out.println("default Fun");
    }

    static void staticFun(){
        System.out.println("static fun");
    }
}


public class L1 implements FuncInterface{

    void test(){

    }

    public static void main(String[] args) {
        L1 l1 = new L1();

    }

}
