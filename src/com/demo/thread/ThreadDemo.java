package com.demo.thread;

import java.lang.ref.SoftReference;

public class ThreadDemo {

    public static void main(String [] args) {
        String fk = "do you like me";
        SoftReference<String> soft = new SoftReference<>(fk);
        System.out.println(soft.get());


    }
}
