package Learning.functionalInterfaces.BiFunction;

@FunctionalInterface
public interface BiFunction<T, U, R> {

//    Takes two inputs and returns a result.

    R apply(T t, U u);

}
