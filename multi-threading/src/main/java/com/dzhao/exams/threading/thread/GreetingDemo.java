package com.dzhao.exams.threading.thread;

import java.util.concurrent.*;

/**
 * Created by Home on 6/08/2015.
 */
public class GreetingDemo {
    public static void main(String[] args) throws InterruptedException {
/*        RejectedExecutionHandler handler = new RejectedExecutionHandler() {
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println(r.toString() + " is rejected");
            }
        };
        ThreadFactory threadFactory = Executors.defaultThreadFactory();*/
        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(5, 10, 60L, TimeUnit.SECONDS,
                //new ArrayBlockingQueue<Runnable>(2),
                new SynchronousQueue<Runnable>(),
                Executors.defaultThreadFactory(),
                //handler
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        GreatingMonitorThread monitorThread = new GreatingMonitorThread(executorPool, "greating monitor", 2);
        monitorThread.start();

        GreatingThread thread1 = new GreatingThread("Dong's thread", "Dong");
        GreatingThread thread2 = new GreatingThread("Kevin's thread", "Kevin");
        GreatingThread thread3 = new GreatingThread("Tony's thread", "Tony");
        GreatingThread thread4 = new GreatingThread("Tom's thread", "Tom");
        GreatingThread thread5 = new GreatingThread("Jerry's thread", "Jerry");
        GreatingThread thread6 = new GreatingThread("Sam's thread", "Sam");
        executorPool.execute(thread1);
        executorPool.execute(thread2);
        executorPool.execute(thread3);
        executorPool.execute(thread4);
        executorPool.execute(thread5);
        executorPool.execute(thread6);
        Thread.sleep(30000);
        executorPool.shutdown();
        Thread.sleep(5000);
        monitorThread.shutdown();
    }
}
