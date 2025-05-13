package test;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
      Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.availableProcessors());
        System.out.println(runtime.maxMemory()/1024/1024);
        System.out.println(runtime.totalMemory()/1024/1024);
        System.out.println(runtime.freeMemory()/1024/1024);
    }
}
