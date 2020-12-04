package com.company.twoTasks;

import sun.plugin.javascript.navig.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        //проверка 1-го
        String [] arr = new String[]{"1", "2", "3", "4"};
        swapArrayElements(arr, 2,3);
        swapArrayElements(arr, 0,1);
        System.out.println(Arrays.toString(arr));
        // проверка 2-го
        leadToArrayList(arr);

    }
    private static <T> void swapArrayElements(T [] arr, int ind1, int ind2)
    {
        T buff = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = buff;
    }
    private static <T> ArrayList<T> leadToArrayList(T[] arr) {
        ArrayList<T> newList = new ArrayList<T>();
        Collections.addAll(newList, arr);
        return newList;
       /* return Arrays.asList(arr) возвращает объект типа List,
       так что как именно преобразовать не знаю, только вернуть.*/
    }

}
