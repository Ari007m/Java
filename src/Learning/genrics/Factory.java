package Learning.genrics;

import java.util.function.Supplier;

public class Factory<T> {

    private Supplier<T> supplier;

    Factory(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    T create() {
        return supplier.get();
    }
}
