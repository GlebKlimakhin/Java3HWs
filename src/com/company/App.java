package com.company;

public class App {

    @BeforeSuite
    public static void begin(){
        System.out.println("Testing...");
    }

    @Test(priority = 10)
    public static void sout() {
        System.out.println("test1");
    }
    @Test(priority = 8)
    public static void sout2(){
        System.out.println("test2");
    }

    @AfterSuite
    public static void end(){
        System.out.println("End.");
    }

}
