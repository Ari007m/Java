package Learning.functionalInterfaces.BiPredicate;

public class Main {
    static void main() {
        BiPredicate<String, Integer> biPredicate = (s, n) -> s.length() == n;

        System.out.println(biPredicate.test("Ari", 3));
    }
}
