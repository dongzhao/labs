package com.dzhao.exams.threading.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by Home on 6/08/2015.
 */
public class GreatingThread implements Runnable{

    private static Logger logger = LoggerFactory.getLogger(GreatingThread.class);

    private String greatingMsg;
    private Thread thread;
    private String threadName;

    public GreatingThread(String threadName, String greatingMsg){
        this.greatingMsg = greatingMsg;
        this.threadName = threadName;
    }

    public void run() {
        process();
    }

    private void process(){
        try {
            Thread.sleep(5 * 1000);
            System.out.println("Hello " + greatingMsg + ", Welcome to my world! at " + new Date());
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public void start(){
        thread = new Thread(this, threadName);
        thread.start();
    }
}
