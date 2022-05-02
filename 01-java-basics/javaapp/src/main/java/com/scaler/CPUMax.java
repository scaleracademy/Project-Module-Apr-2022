package com.scaler;


public class CPUMax {
    public static void main(String[] args) {
        Thread t = new Thread(CPUMax::overloadThread);
        Thread t2 = new Thread(CPUMax::overloadThread);
        t.start();
        t2.start();
    }

    static void overloadThread() {
        var start = System.currentTimeMillis();
        System.out.println("Started at: " + start + " on Thread " + Thread.currentThread().getName());
        while (System.currentTimeMillis() - start < 10000) {}
        System.out.println("Ended on Thread" + Thread.currentThread().getName());
    }
}
