package com.codebuster.puzzle;

import java.io.Console;

public class StopGameThread extends Thread{
    public void run(){
        Console console = System.console();


        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        console.printf("4");
    }
}
