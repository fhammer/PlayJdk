package com.play.jdk.service.thread;

/**
 * Created by fuzh2 on 2017/11/1.
 */
public class Threadtask implements Runnable{
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("T am Thread" + Thread.currentThread().getName());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
