package javapractice.basics;

public class AccessingMembersOftTheClass {

    long contactno = 9535675912l;

    void sendmessage() {
        System.out.println("Send message");
    }

    static int year = 2011;

    static void development() {
        System.out.println("app development product");
    }


}
class Mailclass
{
    static int a = 34;
    void test()
    {
        System.out.println("test method");
    }

    public static void main(String[] args) {
        System.out.println(new AccessingMembersOftTheClass().contactno);
        new AccessingMembersOftTheClass().sendmessage();
        System.out.println(AccessingMembersOftTheClass.year);
        AccessingMembersOftTheClass.development();
        System.out.println(a);
        new Mailclass().test();
        AccessingMembersOftTheClass.year=2026;
        System.out.println(AccessingMembersOftTheClass.year);
    }
}
