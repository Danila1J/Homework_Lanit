package animals;

import model.Size;

public class Rabbit extends Herbivore implements Run, Voice {
    public Rabbit(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Кролик бежит");
    }

    @Override
    public String getVoice() {
        return "Фыр-фыр";
    }

    @Override
    public Size getSize() {
        return Size.SMALL;
    }
}
