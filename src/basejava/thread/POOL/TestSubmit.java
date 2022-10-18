package basejava.thread.POOL;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestSubmit {
    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        Future<String> future = executorService.submit(() -> {
//            System.out.println("开始执行任务.....");
//            Thread.sleep(1000);
//            return "ok";
//        });
//        System.out.println(future.get());
        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(
                () -> {
                    System.out.println("任务一...");
                    Thread.sleep(500);
                    return "1";
                },
                () -> {
                    System.out.println("任务二...");
                    Thread.sleep(1500);
                    return "2";
                }, () -> {
                    System.out.println("任务三...");
                    Thread.sleep(2000);
                    return "3";
                }
        ));
        futures.forEach(f->{
            try {
                System.out.println(f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
    }

}
