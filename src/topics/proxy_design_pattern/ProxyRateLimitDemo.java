package proxyDesignPattern;

import java.util.HashMap;
import java.util.Map;

// Step 1: Subject Interface
interface Service {
    void request(String user);
}

// Step 2: Real Subject
class RealService implements Service {
    @Override
    public void request(String user) {
        System.out.println("Request served for user: " + user);
    }
}

// Step 3: Proxy with Rate Limiting
class RateLimitProxy implements Service {
    private Service realService;
    private Map<String, Integer> requestCounts = new HashMap<>();
    private static final int LIMIT = 3;

    public RateLimitProxy(Service realService) {
        this.realService = realService;
    }

    @Override
    public void request(String user) {
        int count = requestCounts.getOrDefault(user, 0);

        if (count >= LIMIT) {
            System.out.println("Rate limit exceeded for user: " + user);
            return;
        }

        requestCounts.put(user, count + 1);
        realService.request(user);
    }
}

// Step 4: Client
public class ProxyRateLimitDemo {
    public static void main(String[] args) {
        Service service = new RateLimitProxy(new RealService());

        for (int i = 1; i <= 5; i++) {
            service.request("Alice");
        }
        for(int i = 1;i <= 3;i++){
            service.request("Ari");
        }
    }
}
