package Learning.functionalInterfaces.Predicate;

@FunctionalInterface
public interface Predicate<T> {

    // Consumes a value without returning a result.

    boolean test(T t);

}
