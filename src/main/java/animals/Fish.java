package animals;

import model.Size;

public class Fish extends Carnivorous implements Swim {
    public Fish(String name) {
        super(name);
    }

    @Override
    public void swim() {
        System.out.println("Рыба плывет");
    }

    @Override
    public Size getSize() {
        return Size.MEDIUM;
    }
}