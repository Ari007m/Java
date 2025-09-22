package adapterDesignPattern;

public class IndianCars implements Car{

    private String name;
    private String brand;
    private int price;

    IndianCars(String name,String brand , int price){
        this.name =name;
        this.brand=brand;
        this.price = price;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
