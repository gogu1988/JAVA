package LambdaExpressions;

    interface Test1 {
        void print();
    }

    class GfG_3 {
        // functional interface parameter is passed
        public static void fun(Test1 t) { t.print(); }
        public static void main(String[] args)
        {
            // lambda expression is passed
            // without parameter to functional interface t
            fun(() -> System.out.println("Hello"));
        }
    }
