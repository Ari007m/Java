package Learning.functionalInterfaces.BinaryOperator;

public class Main {
    static void main() {
        BinaryOperator<Integer> sum = (a, b) -> a + b;

        System.out.println(sum.apply(7, 8));
    }
}
