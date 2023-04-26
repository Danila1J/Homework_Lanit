package animals;

public class Cow extends Herbivore implements Run, Voice, Swim {
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
}