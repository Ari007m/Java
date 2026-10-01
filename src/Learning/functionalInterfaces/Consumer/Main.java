package Learning.functionalInterfaces.Consumer;

import java.util.function.Consumer;

public class Main {
    static void main() {
        Consumer<String> consume = s -> System.out.println("Welcome " + s);

        consume.accept("Ari");

//        andThen() chains consumers in execution order.

        Consumer<String> c1 = s -> System.out.println(s);
        Consumer<String> c2 = s -> System.out.println(s.length());

        c1.andThen(c2).accept("JAVA");
    }
}
