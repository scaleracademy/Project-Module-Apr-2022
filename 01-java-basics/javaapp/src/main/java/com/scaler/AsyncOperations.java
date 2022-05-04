package com.scaler;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AsyncOperations {

    interface OnTaskEndListener {
        void onTaskEnd();
    }

    static class MockLongTask {
        private final String name;

        public MockLongTask(String name) {
            this.name = name;
        }

        void run(OnTaskEndListener listener) {
            new Thread(() -> {
                System.out.println("MockLongTask.run(" + name + ") started");
                var start = System.currentTimeMillis();
                // fake 10 sec delay
                // in real life, this would be a long running task
                while (System.currentTimeMillis() - start < 10000) {
                }
                System.out.println("MockLongTask.run(" + name + ") ended");
                if (listener != null) {
                    listener.onTaskEnd();
                }
            }).start();
        }

        void run() {
            run(null);
        }
    }

    public static void main(String[] args) {

        var taskA = new MockLongTask("1-download");
        var taskB = new MockLongTask("1-encrypt");
        var taskC = new MockLongTask("2-unrelated");

        taskA.run(() -> taskB.run());
        taskC.run();

        var executor = new ThreadPoolExecutor(
                1,
                4,
                5, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10)
        );

    }
}
