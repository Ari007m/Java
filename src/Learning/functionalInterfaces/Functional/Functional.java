package Learning.functionalInterfaces.Functional;

@FunctionalInterface
public interface Functional<T, R> {

    // Transforms one value into another.

    R apply( T t);
}
