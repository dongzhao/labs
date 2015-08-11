package com.dzhao.exams.threading.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Date;

/**
 * Created by Home on 6/08/2015.
 */
public class FileUploadThread implements Runnable{

    private static Logger logger = LoggerFactory.getLogger(FileUploadThread.class);
    private Thread thread;
    private String threadName;
    private String from;
    private String to;

    public FileUploadThread(String from, String to, String threadName){
        this.threadName = threadName;
        this.from = from;
        this.to = to;
    }

    public void run() {
        System.out.println("Start the copy from [" + from + "] to [" + to + "] at the time " + new Date());
        try {
            try {
                MyFileUtil.saveAs(from, to);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finish the copy from [" + from + "] to [" + to + "] at the time ");
        }
    }

    public void start(){
        thread = new Thread(this, threadName);
        thread.start();
    }
}
