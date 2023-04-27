package animals;

import model.Size;

public class Kotik extends Carnivorous implements Run, Swim, Voice {
    private int weight;//в граммах
    private String voice;
    private static final int METHODS = 5;
    private static int count;

    public static int getCount() {
        return count;
    }

    @Override
    public int getSatiety() {
        return satiety;
    }

    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public Kotik(String name) {
        super(name);
        count++;
    }

    public Kotik(String name, String voice, int satiety, int weight) {
        this(name);
        this.voice = voice;
        this.satiety = satiety;
        this.weight = weight;
    }

    public boolean play() {
        if (satiety > 0) {
            System.out.println("Котик " + super.getName() + " играет.");
            satiety--;
            return true;
        } else {
            System.out.println("Котик " + super.getName() + " хочет есть.");
            return false;
        }
    }

    public boolean sleep() {
        if (satiety > 0) {
            System.out.println("Котик " + super.getName() + " спит.");
            satiety--;
            return true;
        } else {
            System.out.println("Котик " + super.getName() + " хочет есть.");
            return false;
        }
    }

    public boolean wash() {
        if (satiety > 0) {
            System.out.println("Котик " + super.getName() + " моется.");
            satiety--;
            return true;
        } else {
            System.out.println("Котик " + super.getName() + " хочет есть.");
            return false;
        }
    }

    public boolean walk() {
        if (satiety > 0) {
            System.out.println("Котик " + super.getName() + " гуляет.");
            satiety--;
            return true;
        } else {
            System.out.println("Котик " + super.getName() + " хочет есть.");
            return false;
        }
    }

    public boolean hunt() {
        if (satiety > 0) {
            System.out.println("Котик " + super.getName() + " охотится.");
            satiety--;
            return true;
        } else {
            System.out.println("Котик " + super.getName() + " хочет есть.");
            return false;
        }
    }

    public void eat(int foodAmount) {
        satiety += foodAmount;
    }

    public void eat(int foodAmount, String foodName) {
        satiety += foodAmount;
        System.out.println("Котик ест " + foodName);
    }

    public void eat() {
        eat(5, "рыба");
    }

    public String[] liveAnotherDay() {
        String[] actions = new String[24];
        for (int i = 0; i < actions.length; i++) {
            if (satiety <= 0) {
                eat();
                actions[i] = i + " - ел";
                continue;
            }
            int randomAction = (int) (Math.random() * METHODS);
            switch (randomAction) {
                case 0:
                    if (play()) actions[i] = i + " - играл";
                    break;
                case 1:
                    if (sleep()) actions[i] = i + " - спал";
                    break;
                case 2:
                    if (wash()) actions[i] = i + " - мылся";
                    break;
                case 3:
                    if (walk()) actions[i] = i + " - гулял";
                    break;
                case 4:
                    if (hunt()) actions[i] = i + " - охотился";
                    break;
                default:
                    break;
            }
        }
        return actions;
    }

    @Override
    public void run() {
        System.out.println("Котик бежит");
    }

    @Override
    public void swim() {
        System.out.println("Котик плывет");
    }

    @Override
    public Size getSize() {
        return Size.SMALL;
    }
}