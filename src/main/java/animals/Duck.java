package animals;

public class Duck extends Herbivore implements Swim, Fly, Voice, Run {

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
}