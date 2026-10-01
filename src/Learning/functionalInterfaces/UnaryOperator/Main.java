package Learning.functionalInterfaces.UnaryOperator;

public class Main {
    static void main() {
        UnaryOperator<Integer> square = n -> n * n;

        System.out.println(square.apply(20));
    }
}
