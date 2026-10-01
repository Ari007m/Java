package Learning.functionalInterfaces.UnaryOperator;

@FunctionalInterface
public interface UnaryOperator<T> {

    // A specialized Function<T,T> where input and output have the same type.

    T apply(T t);
}
