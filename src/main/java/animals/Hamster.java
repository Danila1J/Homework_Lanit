package animals;

public class Hamster extends Herbivore implements Run, Voice {
    @Override
    public void run() {
        System.out.println("Хомяк бежит");
    }

    @Override
    public String getVoice() {
        return "Писк";
    }
}
