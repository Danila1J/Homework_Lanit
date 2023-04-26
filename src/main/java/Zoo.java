import animals.*;
import employee.Worker;
import food.Food;
import food.Grass;
import food.Meat;

public class Zoo {
    public static void main(String[] args) {
        Food meat = new Meat();
        Food grass = new Grass();

        Worker worker = new Worker();

        Cow cow = new Cow();//Herbivore
        Duck duck = new Duck();//Carnivorous
        Fish fish = new Fish();//Carnivorous
        Kotik kotik = new Kotik();//Carnivorous
        Rabbit rabbit = new Rabbit();//Herbivore
        Hamster hamster = new Hamster();//Herbivore

        worker.feed(cow,grass);
        worker.feed(cow,meat);
        worker.feed(fish,grass);
        worker.feed(fish,meat);

        System.out.println(cow.getVoice());
        //System.out.println(fish.getVoice()); //Ошибка!!!

        Swim[] pond = createPond();
        for (Swim animal : pond) {
            animal.swim();
        }
    }

    static Swim[] createPond() {
        return new Swim[]{new Cow(), new Duck(), new Fish(), new Kotik()};
    }
}
