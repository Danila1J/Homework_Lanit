package model;

import animals.Animal;

import java.util.HashMap;
import java.util.Map;

public class Aviary<T extends Animal> {
    private Size size;

    private Map<String, T> aviaryMap=new HashMap<>();

    public Aviary(Size size) {
        this.size = size;
    }

    public void addAnimal(T animal){
        if(size == animal.getSize()){
            aviaryMap.put(animal.getName(),animal);
        }else {
            throw new WrongSizeException();
        }
    }

    public T getAnimal(String name){
        return aviaryMap.get(name);
    }

    public boolean removeAnimal(String name){
        return aviaryMap.remove(name) != null;
    }
}
