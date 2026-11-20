package Learning;

public interface Demo {

    String hello();

    default void sout(){
        System.out.println("Default return");
    }
}

class Demo1 implements Demo{

    @Override
    public String hello() {
        return "Hello";
    }

    @Override
    public void sout() {
//        Demo.super.sout();
        System.out.println("In demo1 class");

    }

    static void main() {
        Demo1 demo = new Demo1();
        demo.sout();
        System.out.println(demo.hello());
    }

}