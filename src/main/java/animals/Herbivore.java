package animals;

import food.Food;
import food.Grass;
import food.WrongFoodException;

public abstract class Herbivore extends Animal {

    public Herbivore(String name) {
        super(name);
    }

    @Override
    public void eat(Food food) throws WrongFoodException {
        if (food instanceof Grass) {
            satiety += food.getEnergy();
            System.out.println(getClass().getSimpleName() + " Кушает траву");
        } else {
            throw new WrongFoodException();
        }
    }
}
