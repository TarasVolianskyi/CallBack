package sample;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RunTimeManager {

    private String command;

    public RunTimeManager(String command) {
        this.command = command;
    }

    public void thread() {
        Thread myThread = new Thread();
        myThread.start();
    }

    public void run() {
        System.out.println("text");
    }

    public String executeComand() {
        StringBuffer output = new StringBuffer();
        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output.toString();
    }


}
