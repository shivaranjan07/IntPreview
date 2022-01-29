package Threads;

import java.util.concurrent.*;

public class ExecutorDemo {
    static ExecutorService threadPool = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Executor executor = Executors.newFixedThreadPool(2);
//        executor.execute(() -> Arrays.stream(new int[]{1, 2, 3}).forEach(System.out::println));
//        executor.execute(() -> System.out.println("hello world"));

//        final int n = 10;
//        Future<Integer> future = threadPool.submit(() -> {
//           int sum=0;
//           for(int i=0;i<=n;i++) {
//               sum+=i;
//           }
//           return sum;
//        });
//
//        System.out.println(future.get());

        final int n=10;
        System.out.println(pollingStatusAndCancelTask(10));
        threadPool.shutdown();
    }

    private static int pollingStatusAndCancelTask(int n) {
        int result = -1;
        Callable<Integer> sumTask = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for(int i=0;i<=n;i++) sum+=i;

                return sum;
            }
        };

        Callable<Void> randomTask = new Callable<Void>() {

            public Void call() throws Exception {

                // go to sleep for an hours
                Thread.sleep(3600 * 1000);
                return null;
            }
        };

        Future<Integer> f1 = threadPool.submit(sumTask);
        Future<Void> f2 = threadPool.submit(randomTask);

        try {
            // Before we poll for completion of second task,
            // cancel the second one
            f2.cancel(true);

            // Polling the future to check the status of the
            // first submitted task
            while(!f1.isDone()) {
                System.out.println("Waiting for first task to complete.");
            }
            result = f1.get();
        } catch (ExecutionException e) {
            System.out.println("Something went wrong.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nIs second task cancelled : " + f2.isCancelled());

        return result;
    }
}
