package Learning.functionalInterfaces.Functional;

import java.util.function.Function;

public class Main {
    static void main() {

        Functional<String, Integer> length = new Functional<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };

        Function<String, String> identity = Function.identity(); // This returns unchanged input as output

        System.out.println(length.apply("Apple"));
    }
}
