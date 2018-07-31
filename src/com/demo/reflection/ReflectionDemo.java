package com.demo.reflection;

public class ReflectionDemo {
    public static void main(String [] args) {
        Benz benz = (Benz) Factory.getInstance("com.demo.reflaction.Benz");
        benz.run();
    }
}

class Factory{
//    反射前编码
//    public static Car getInstance(String brand) {
//        Car car = null;
//
//        if ("Benz".equalsIgnoreCase(brand)) {
//            car = new Benz();
//        }
//        if ("BMW".equalsIgnoreCase(brand)) {
//            car = new BMW();
//        }
//
//        return  car;
//    }

    //反射后编码
    public static Object getInstance(String className) {
        Object obj = null;

        try {
            obj = Class.forName(className).newInstance();
        }catch (Exception e) {
            e.printStackTrace();
        }

        return  obj;
    }
}
