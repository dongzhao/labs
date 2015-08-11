package com.dzhao.exams.threading.file;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Home on 6/08/2015.
 */
public class FileUploadMonitorThread implements Runnable{

    private String threadName;
    private Thread thread;
    private ThreadPoolExecutor poolExecutor;
    private int seconds;
    private boolean run = true;

    public FileUploadMonitorThread(ThreadPoolExecutor poolExecutor, String threadName, int delay){
        this.poolExecutor = poolExecutor;
        this.threadName = threadName;
        this.seconds = delay;
    }

    public void run() {
        while(run){
            System.out.println(
                    String.format("[monitor] [%d/%d] Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s",
                            this.poolExecutor.getPoolSize(),
                            this.poolExecutor.getCorePoolSize(),
                            this.poolExecutor.getActiveCount(),
                            this.poolExecutor.getCompletedTaskCount(),
                            this.poolExecutor.getTaskCount(),
                            this.poolExecutor.isShutdown(),
                            this.poolExecutor.isTerminated()));
            try {
                Thread.sleep(seconds*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown(){
        this.run = false;
    }

    public void start(){
        thread = new Thread(this, threadName);
        thread.start();
    }
}
