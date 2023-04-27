package animals;

import food.Food;
import food.Meat;
import food.WrongFoodException;

public abstract class Carnivorous extends Animal {

    public Carnivorous(String name) {
        super(name);
    }

    @Override
    public void eat(Food food) throws WrongFoodException {
        if (food instanceof Meat) {
            super.satiety += food.getEnergy();
            System.out.println(getClass().getSimpleName() + " Кушает мясо");
        } else {
            throw new WrongFoodException();
        }
    }
}
