package animals;

import model.Size;

public class Duck extends Herbivore implements Swim, Fly, Voice, Run {

    public Duck(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println("Утка летит");
    }

    @Override
    public void swim() {
        System.out.println("Утка плывет");
    }

    @Override
    public String getVoice() {
        return "Кря";
    }

    @Override
    public void run() {
        System.out.println("Утка бежит");
    }

    @Override
    public Size getSize() {
        return Size.SMALL;
    }
}