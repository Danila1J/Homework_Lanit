package animals;

import model.Size;

public class Cow extends Herbivore implements Run, Voice, Swim {
    public Cow(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Корова бежит");
    }

    @Override
    public void swim() {
        System.out.println("Корова плывет");
    }

    @Override
    public String getVoice() {
        return "Муу";
    }

    @Override
    public Size getSize() {
        return Size.LARGE;
    }
}