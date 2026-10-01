package Learning.functionalInterfaces.BiFunction;

public class Main {
    static void main() {
        BiFunction<String, Integer, String> biFunction = (a,n) -> a.repeat(n);

        System.out.println(biFunction.apply("ari ", 3));
    }
}
