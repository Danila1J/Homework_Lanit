import animals.Kotik;

public class Application {
    public static void main(String[] args) {
        Kotik kotik1 = new Kotik("Мурзик", "Мяу", 10, 5500);
        Kotik kotik2 = new Kotik("Барсик");
        //kotik2.setName("Барсик");
        kotik2.setVoice("Мяу");
        kotik2.setSatiety(5);
        kotik2.setWeight(4500);
        String[] actions = kotik1.liveAnotherDay();
        for (String action : actions) {
            System.out.println(action);
        }
        System.out.println("Имя котика: " + kotik1.getName() + ", вес котика: " + kotik1.getWeight());
        boolean isVoiceEqual = compareVoice(kotik1, kotik2);
        System.out.println("Одинаково ли разговаривают котики? " + isVoiceEqual);
        System.out.println("Количество котиков: " + Kotik.getCount());
    }

    private static boolean compareVoice(Kotik kotik1, Kotik kotik2) {
        return kotik1.getVoice().equals(kotik2.getVoice());
    }
}