package proxyDesignPattern;

public class LabDoor implements Door{
    @Override
    public void open(String param) {
        System.out.println("The Lab door is Opened, "+param);
    }

    @Override
    public void close() {
        System.out.println("The Lab door is Closed.");
    }
}
