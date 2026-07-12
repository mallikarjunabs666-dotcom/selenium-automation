package Interviewpractise;

public class test
{
    int a = 10;
    static int b = 20;

    static void test()
    {
        System.out.println("test method");
    }

    public static void main(String[] args) {

        System.out.println(b);
        test();
        new test().run();
    }

    void run()
    {
        System.out.println(b);
        test();
    }
}
