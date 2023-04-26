package animals;

import food.Food;
import food.Grass;

public abstract class Herbivore extends Animal {
    @Override
    public void eat(Food food) {
        if (food instanceof Grass){
            satiety+=food.getEnergy();
            System.out.println(getClass().getSimpleName()+" Кушает траву");
        }else {
            System.out.println("Травоядное не ест мясо");
        }
    }
}
