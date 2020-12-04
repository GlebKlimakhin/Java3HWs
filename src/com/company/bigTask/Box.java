package com.company.bigTask;

import com.company.bigTask.Fruits.Fruit;
import java.util.ArrayList;
import java.util.Arrays;

public class Box <T extends Fruit> {
    ArrayList <T> fruitsBox;

    public Box(T... fruitArray) {
        fruitsBox = new ArrayList<T>(Arrays.asList(fruitArray));
    }
    public void addFruit(T fruit)
    {
        fruitsBox.add(fruit);
    }
    public float getBoxWeight()
    {
        float totalWeight = 0.0f;
        for (T box : fruitsBox) totalWeight += box.getWeight();
        return totalWeight;
    }
    public boolean Compare(Box box)
    {
        return Math.abs(this.getBoxWeight() - box.getBoxWeight()) < 0.004;
    }
    public void shiftFruits(Box <T> box)
    {
        box.fruitsBox.addAll(this.fruitsBox);
        this.fruitsBox.clear();
    }

}
