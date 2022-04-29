package com.scaler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InheritenceFun {

    static class GrandParent {
        public boolean isSeniorCitizen () {
            return getAge() >= 60;
        }
        protected int getAge() {
            return 60;
        }
    }
    static class Parent extends GrandParent {
        @Override
        protected int getAge() {
            return 40;
        }
    }
    static class Child extends Parent {
        @Override
        protected int getAge() {
            return 20;
        }

        public String getFavouriteCartoon() {
            return "Tom and Jerry";
        }
    }

    static void genericAgePrinter(Object x) {
        try {
            Method getAge = x.getClass().getDeclaredMethod("getAge");
            if (getAge.canAccess(x)) {
                System.out.println(getAge.invoke(x));
            } else {
                getAge.setAccessible(true);
                System.out.println(getAge.invoke(x));
            }

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            System.err.println("No getAge method");
        }
    }

    public static void main(String[] args) {
        Child c = new Child();
        System.out.println(c.isSeniorCitizen());
        GrandParent gp = new GrandParent();
        System.out.println(gp.isSeniorCitizen());
        GrandParent gp2 = new Child();
        System.out.println(gp2.isSeniorCitizen()); // ?

        System.out.println(gp2.getClass().equals(GrandParent.class));
        System.out.println(gp2.getClass().equals(Child.class));

        genericAgePrinter(gp);
        genericAgePrinter(c);

    }

}
