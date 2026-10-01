package Learning.functionalInterfaces.Supplier;

//import java.util.function.Supplier;

public class Main {

    static void main() {
        Supplier<Double> supplier = () -> Math.random();

        System.out.println(supplier.get());
    }


}
