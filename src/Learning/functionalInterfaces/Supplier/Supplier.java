package Learning.functionalInterfaces.Supplier;

@FunctionalInterface
public interface Supplier<T> {
    // Produces a value without taking an input.
    T get();
}
