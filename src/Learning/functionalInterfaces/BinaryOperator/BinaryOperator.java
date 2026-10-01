package Learning.functionalInterfaces.BinaryOperator;

@FunctionalInterface
public interface BinaryOperator<T> {

    // A specialized BiFunction<T,T,T>.

    T apply(T a, T b);
}
