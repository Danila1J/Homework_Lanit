package animals;

import food.Food;
import food.WrongFoodException;
import model.Size;

public abstract class Animal {
    protected int satiety;

    private String name;

    public String getName() {
        return name;
    }

    public Animal(String name){this.name=name;}
    public abstract Size getSize();

    public int getSatiety() {
        return satiety;
    }

    public abstract void eat(Food food) throws WrongFoodException;
}
