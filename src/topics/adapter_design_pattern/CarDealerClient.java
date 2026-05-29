package adapterDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class CarDealerClient {
    public List<Car> getCarList(){
        List<Car> car = new ArrayList<>();

        Car indianCar1 = new IndianCars("Tata","Punch",1000000);
        Car foreignCar = new ForeignCarAdapter(new ForeignCars("Spectre","Rolls Royce", 10000000));

        car.add(indianCar1);
        car.add(foreignCar);
        return car;
    }
}
