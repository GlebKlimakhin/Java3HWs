package com.company;

public class Service {

    @BeforeSuite
    public void begin() {
        System.out.println("Testing...");
    }

    @Test(priority = 1)
    public static void sout(int a) {
        System.out.println("test1");
    }

    @Test(priority = 2)
    public static void sout2(int a) {
        System.out.println("test2");
    }

    @Test
    public static void sout3(int a) {
        System.out.println("test3");
    }

    @AfterSuite
    public static void end() {
        System.out.println("End.");
    }

}
