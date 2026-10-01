package Learning.functionalInterfaces.Predicate;

public class Main {
    static void main() {

//        Predicate<Integer> isEven = new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) {
//                return integer % 2 == 0;
//            }
//        };

        // The above code snippet is equivalent to the below line of code

        Predicate<Integer> isEven = n -> n % 2 == 0;

        System.out.println(isEven.test(20));
    }
}
