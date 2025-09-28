package thread_pool_executor;

import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {

        ThreadPoolExecutor executor =new ThreadPoolExecutor(2, 4, 5, TimeUnit.MINUTES, new ArrayBlockingQueue<>(2), new CustomThreadFactory(), new CustomRejectionHandle());

        for(int i=1;i<=7;i++){
            executor.submit(() ->{
                try {
                    Thread.sleep(5000);
                }
                catch (Exception e){

                }
                System.out.println("The task finished : " + Thread.currentThread().getName());
            });
        }


        executor.shutdown();
    }
}

class CustomThreadFactory implements ThreadFactory{
    @Override
    public Thread newThread(Runnable r) {
        Thread th = new Thread(r);
        th.setPriority(Thread.NORM_PRIORITY);
        th.setDaemon(false);
        return th;
    }
}

class CustomRejectionHandle implements RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task rejected: "+ r.toString());
    }
}