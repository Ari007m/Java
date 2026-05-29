package proxyDesignPattern;

public class Main {
    public static void main(String[] args) {
        Door door= new SecureDoor(new LabDoor());
        door.open("Invalid");
        door.open("Ari123");
        door.close();
    }
}
