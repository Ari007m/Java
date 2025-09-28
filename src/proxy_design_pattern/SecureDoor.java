package proxyDesignPattern;

public class SecureDoor implements Door{

    /*
        This is the proxy method
        We can use it like this and also for the Objects(Object Data Mapper(ODM))
     */

    Door door;
    public SecureDoor(Door door){
        this.door=door;
    }

    @Override
    public void open(String password) {
        if(authenticate(password)){
            door.open("The Password is correct!");
        }
        else{
            System.out.println("Sorry!, You entered wrong passcode.");
        }
    }

    private boolean authenticate(String password) {
        return "Ari123".equals(password);
    }

    @Override
    public void close() {
        door.close();
    }
}
