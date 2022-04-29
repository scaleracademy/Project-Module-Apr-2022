package com.scaler;


public class BasicOops {

    static class Fruit {
        private int origin = 1; // 1 = India, 2 = USA, 3 = China
        public String getTaste() {
            if (origin == 1) {
                return "Sweet";
            } else {
                return "Sour";
            }
        }
    }

    static class Mango extends Fruit {
    }

    public static void main(String[] args) {
        Fruit f = new Mango();
        Mango m = (Mango) new Fruit();

    }
}
