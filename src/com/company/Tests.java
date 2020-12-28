package com.company;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;

public class Tests {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите имя папки, в которой лежит класс и класса, например com.company.App");
        Scanner sc = new Scanner(System.in);
        start(Class.forName(sc.next()));
    }

    public static void start(Class testClass) throws Exception {
        Object testObj = testClass.newInstance();
        ArrayList<Method> testMethods = new ArrayList<>();
        byte beforeCounter = 0;
        byte afterCounter = 0;
        Method beforeMethod = null;
        Method afterMethod = null;
        Method[] allMethods = testClass.getDeclaredMethods();
        for (Method method : allMethods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                beforeMethod = method;
                beforeCounter++;
            }
            if (beforeCounter > 1) {
                throw new RuntimeException("More than one method with @BeforeSuite annotation in the testing class");
            }

            if (method.isAnnotationPresent(AfterSuite.class)) {
                afterCounter++;
                afterMethod = method;
            }
            if (afterCounter > 1) {
                throw new RuntimeException("More than one method with @BeforeSuite annotation in the testing class");
            }
            if (method.isAnnotationPresent(Test.class)) {
                testMethods.add(method);
            }
        }
        testMethods.sort((o1, o2) -> o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority());
        if (beforeMethod != null) {
            beforeMethod.invoke(testObj, null);
        }
        for (Method testMethod : testMethods) {
            testMethod.invoke(testObj, null);
        }
        if (afterMethod != null) {
            afterMethod.invoke(testObj, null);
        }
    }

}

