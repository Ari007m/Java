package Learning.genrics;

class User{
    User(){
        System.out.println("User creation");
    }
}

public class Main {

    static void main() {
        Factory<User> factory = new Factory<>(User::new);
        factory.create();
//        System.out.println();
    }
}
