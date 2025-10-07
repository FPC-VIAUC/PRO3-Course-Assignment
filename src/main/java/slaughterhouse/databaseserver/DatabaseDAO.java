package slaughterhouse.databaseserver;

import slaughterhouse.domain.Animal;

public interface DatabaseDAO{
  void addAnimal(Animal animal);
  int getNextAnimalId();
}
