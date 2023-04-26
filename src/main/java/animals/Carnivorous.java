package animals;

import food.Food;
import food.Meat;

public abstract class Carnivorous extends Animal {

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            super.satiety += food.getEnergy();
            System.out.println(getClass().getSimpleName()+" Кушает мясо");
        } else {
            System.out.println("Плотоядное не ест траву");
        }
    }
}
