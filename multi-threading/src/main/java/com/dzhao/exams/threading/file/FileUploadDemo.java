package com.dzhao.exams.threading.file;

import com.dzhao.exams.threading.thread.GreatingMonitorThread;
import com.dzhao.exams.threading.thread.GreatingThread;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Home on 6/08/2015.
 */
public class FileUploadDemo {

    public static void main(String args[]) throws InterruptedException, IOException {

        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(5, 10, 60L, TimeUnit.SECONDS,
                //new ArrayBlockingQueue<Runnable>(2),
                new SynchronousQueue<Runnable>(),
                Executors.defaultThreadFactory(),
                //handler
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        FileUploadMonitorThread monitorThread = new FileUploadMonitorThread(executorPool, "file upload monitor", 2);
        monitorThread.start();

        Path currentRelativePath = Paths.get("");
        String currentPath = currentRelativePath.toAbsolutePath().toString();
        String fromFolder = currentPath + "\\files\\from\\";
        String toFolder = currentPath + "\\files\\to\\";
        File folder = new File(fromFolder);
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            String fileName = listOfFiles[i].getName();
            FileUploadThread thread = new FileUploadThread(fromFolder + fileName, toFolder + fileName, "Uploading " + fileName);
            executorPool.execute(thread);
        }

        Thread.sleep(30000);
        executorPool.shutdown();
        Thread.sleep(5000);
        monitorThread.shutdown();
    }
}
