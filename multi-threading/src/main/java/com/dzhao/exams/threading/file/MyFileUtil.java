package com.dzhao.exams.threading.file;

import java.io.*;

/**
 * Created by Home on 6/08/2015.
 */
public class MyFileUtil {

    private MyFileUtil(){}

    public static void saveAs(String from, String to) throws IOException, InterruptedException {
        FileInputStream in = null;
        try {
            in = new FileInputStream(from);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(to);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int c;
        try {
            while ((c = in.read()) != -1) {
                    out.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            Thread.sleep(5*1000);
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
