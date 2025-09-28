package adapterDesignPattern;

public class ForeignCarAdapter implements Car{

    ForeignCars foreignCars;

    public ForeignCarAdapter(ForeignCars foreignCars){
        this.foreignCars =foreignCars;
    }

    @Override
    public String getName() {
        return foreignCars.getCarName();
    }

    @Override
    public String getBrand() {
        return foreignCars.getCarBrand();
    }

    @Override
    public int getPrice() {
        return foreignCars.getCarPrice();
    }
}
