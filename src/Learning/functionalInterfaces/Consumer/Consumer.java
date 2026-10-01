package Learning.functionalInterfaces.Consumer;

@FunctionalInterface // verifies whether this is functional interface are not
public interface Consumer<T> {

    // Tests a condition and returns boolean.

    void accept(T t);
}
