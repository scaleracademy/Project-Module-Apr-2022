package com.scaler;

public class AsyncOperations {

    static class MockLongTask {
        void run () {
            new Thread(() -> {
                System.out.println("MockLongTask.run() started");
                var start = System.currentTimeMillis();
                while (System.currentTimeMillis() - start < 10000) {}
                System.out.println("MockLongTask.run() ended");

            }).start();
        }
    }

    public static void main(String[] args) {
        var task1 = new MockLongTask();
        var task2 = new MockLongTask();
    }
}
