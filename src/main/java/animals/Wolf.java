package animals;

import model.Size;

public class Wolf extends Carnivorous implements Run, Voice {
    public Wolf(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Волк бежит");
    }

    @Override
    public String getVoice() {
        return "Ррррр";
    }

    @Override
    public Size getSize() {
        return Size.LARGE;
    }
}
