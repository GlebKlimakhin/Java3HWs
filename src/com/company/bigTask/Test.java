package com.company.bigTask;


import com.company.bigTask.Fruits.Apple;
import com.company.bigTask.Fruits.Orange;

public class Test {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<Apple>();
        //Добавляем в коробку для яблок яблоки
        for (int i = 0; i < 3; i++)
        {
            appleBox.addFruit(new Apple());
        }
        Box <Orange> orangeBox = new Box<>();
        //Добавляем в коробку для апельсинов апельсины
        for (int i = 0; i < 4; i++)
        {
            orangeBox.addFruit(new Orange());
        }
        System.out.println(orangeBox.Compare(appleBox));
        //appleBox.shiftFruits(orangeBox); - невозможная операция
        Box <Apple> appleBox1 = new Box<>();
        appleBox.shiftFruits(appleBox1);
        System.out.println(appleBox1.getBoxWeight());
        System.out.println(appleBox.getBoxWeight());

    }
}
