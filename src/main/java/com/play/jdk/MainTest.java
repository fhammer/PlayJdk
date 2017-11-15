package com.play.jdk;

import com.play.jdk.service.UserService;
import com.play.jdk.service.thread.Threadtask;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.Callable;

/**
 * Created by fuzh2 on 2017/10/31.
 */
public class MainTest {

    public static void main(String[] args) throws InterruptedException {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-application.xml");
//        UserService serviceId_1 = (UserService) applicationContext.getBean("userServiceId_1");
//        UserService serviceId_2 = (UserService) applicationContext.getBean("userServiceId_2");
//
//        System.out.println(serviceId_1);
//        System.out.println(serviceId_2);

//        testThread();
        System.out.println(finaliyTest());

        String  flag="";
        switch (flag){
            case "==":
                break;
        }
    }

    private static String finaliyTest() {
        StringBuilder sb=new StringBuilder();
        try {
            sb.append("hhahahahahhah");
            return sb.toString();
        }catch (Exception e){
            e.printStackTrace();
            sb.append("exception");
        }finally {
            sb.append("===========");
        }
        return sb.toString();
    }

    private static void testThread() throws InterruptedException {
        Thread thread = new Thread(new Threadtask());
        System.out.println("Thread Main " + Thread.currentThread().getName());
        thread.start();
        Thread.sleep(200);
        System.out.println("Thread Main join");
        thread.join();
        System.out.println("Main Thread End ...");

//        Callable
    }

}
