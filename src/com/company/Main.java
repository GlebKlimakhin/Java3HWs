package com.company;


public class Main {

    private static volatile int counter = 1;
    private static final Object obj = new Object();
    private static final int number= 5;
    /*1. Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз
       (порядок – ABСABСABС). Используйте wait/notify/notifyAll.
        */
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < number; i++) {
                synchronized (obj) {
                    while (counter != 1) {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("A ");
                    counter = 2;
                    obj.notifyAll();
                }
            }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < number; i++) {
                synchronized (obj){
                    while (counter != 2){
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("B ");
                    counter = 3;
                    obj.notifyAll();
                }
            }
        });
        t2.start();
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < number; i++) {
                synchronized (obj){
                    while (counter != 3){
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("С ");
                    counter = 1;
                    obj.notifyAll();
                }
            }
        });
        t3.start();

    }
}
