package adapterDesignPattern;

import java.util.List;

public class CarShop {
    public static void main(String[] args) {

        CarDealerClient client = new CarDealerClient();
        List<Car> cars = client.getCarList();
        for(Car car : cars){
            System.out.println("The car is : "+car.getName());
            System.out.println("The brand is : "+car.getBrand());
            System.out.println("The price is : "+car.getPrice());
            System.out.println();
        }
    }
}
