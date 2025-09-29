package adapterDesignPattern;

public class ForeignCars {

    private String carName;
    private String carBrand;
    private int carPrice;

    ForeignCars(String carName, String carBrand ,int carPrice){
        this.carName = carName;
        this.carBrand = carBrand;
        this.carPrice = carPrice;
    }

    public int getCarPrice() {
        return carPrice;
    }

    public String getCarName() {
        return carName;
    }

    public String getCarBrand() {
        return carBrand;
    }
}
