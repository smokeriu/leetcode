package util;

public class ThreadTest {


    public static void main(String[] args) {
        new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        }.run();
    }
}
