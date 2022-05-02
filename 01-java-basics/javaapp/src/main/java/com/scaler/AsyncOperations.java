package com.scaler;

public class AsyncOperations {

    static class MockLongTask {
        private String name;
        public MockLongTask(String name) {
            this.name = name;
        }

        void run () {
            new Thread(() -> {
                System.out.println("MockLongTask.run(" + name + ") started");
                var start = System.currentTimeMillis();
                // fake 10 sec delay
                // in real life, this would be a long running task
                while (System.currentTimeMillis() - start < 10000) {}
                System.out.println("MockLongTask.run("+ name + ") ended");

            }).start();
        }
    }

    public static void main(String[] args) {
        var task1 = new MockLongTask("download");
        var task2 = new MockLongTask("encrypt");

        task1.run();
        task2.run();
    }
}
