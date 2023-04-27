import animals.*;
import employee.Worker;
import food.Food;
import food.Grass;
import food.Meat;
import model.Aviary;
import model.Size;

public class Zoo {

    private static Aviary<Carnivorous> carnivorousAviary = new Aviary<>(Size.SMALL);
    private static Aviary<Herbivore> herbivoreAviary = new Aviary<>(Size.LARGE);

    public static void main(String[] args) {
        Food meat = new Meat();
        Food grass = new Grass();

        Worker worker = new Worker();

        Cow cow = new Cow("Корова");//Herbivore
        Duck duck = new Duck("Утка");//Herbivore
        Fish fish = new Fish("Рыба");//Carnivorous
        Kotik kotik = new Kotik("Котик");//Carnivorous
        Rabbit rabbit = new Rabbit("Кролик");//Herbivore
        Wolf wolf = new Wolf("Волк");//Carnivorous

        worker.feed(cow, grass);
        //worker.feed(cow, meat); //WrongFoodException
        //worker.feed(fish, grass); ////WrongFoodException
        worker.feed(fish, meat);

        System.out.println(cow.getVoice());
        //System.out.println(fish.getVoice()); //Ошибка!!!

        Swim[] pond = createPond();
        for (Swim animal : pond) {
            animal.swim();
        }

        fillCarnivorousAviary();
        fillHerbivoreAviary();

        System.out.println(getCarnivorous("Котик").getName());
        System.out.println(getCarnivorous("Котик2").getName());
    }

    private static Swim[] createPond() {
        return new Swim[]{new Cow("Корова"), new Duck("Утка"), new Fish("Рыба"), new Kotik("Котик")};
    }

    private static void fillHerbivoreAviary() {
        //herbivoreAviary.addAnimal(new Duck("Утка")); //WrongSizeException
        herbivoreAviary.addAnimal(new Cow("Корова"));
        herbivoreAviary.addAnimal(new Cow("Корова2"));
        //herbivoreAviary.addAnimal(new Wolf("Волк")); // Ошибка!!! Платоядное
    }

    private static void fillCarnivorousAviary() {
        //carnivorousAviary.addAnimal(new Fish("Рыба")); //WrongSizeException
        carnivorousAviary.addAnimal(new Kotik("Котик"));
        carnivorousAviary.addAnimal(new Kotik("Котик2"));
        //carnivorousAviary.addAnimal(new Duck("Утка"));//  Ошибка!!! Травоядное
    }

    private static Carnivorous getCarnivorous(String name){
        return carnivorousAviary.getAnimal(name);
    }

    private static Herbivore getHerbivore(String name){
        return herbivoreAviary.getAnimal(name);
    }
}
