package com.play.jdk.service.thread;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by fuzh2 on 2017/11/15.
 */
public class CaalAbleAndFuture {
    public static void main(String[] args) {
//        futureTask();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(new CallAbleTest());
//        executor.shutdown();
        try {
            Thread.sleep(5000);
            System.out.println("Result=  "+future.get());
        }catch (InterruptedException e){
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void futureTask() {
        FutureTask<Integer> futureTask = new FutureTask<>(new CallAbleTest());
        new Thread(futureTask).start();
        try {
            Thread.sleep(5000);
            System.out.println("Result= "+futureTask.get());
        }catch (InterruptedException e){
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class CallAbleTest implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int nextInt = new Random(100).nextInt();
        System.out.println("Callable ="+nextInt);
        return nextInt;
    }
}

