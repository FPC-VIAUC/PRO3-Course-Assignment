package slaughterhouse.databaseserver;

import slaughterhouse.domain.Animal;

import java.util.ArrayList;

public class ArrayDatabase implements DatabaseDAO{
  private ArrayList<Animal> animals;

  public ArrayDatabase(){
    animals = new ArrayList<>();
  }

  @Override public void addAnimal(Animal animal){
    animals.add(animal);
  }

  @Override public int getNextAnimalId(){
    int max = 0;
    for(Animal animal : animals){
      if(animal.getId() > max) max = animal.getId();
    }
    return max + 1;
  }
}
