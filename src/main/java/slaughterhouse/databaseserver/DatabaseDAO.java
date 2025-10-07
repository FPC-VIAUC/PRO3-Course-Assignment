package slaughterhouse.databaseserver;

import slaughterhouse.domain.*;

import java.util.List;

public interface DatabaseDAO{
  void addAnimal(Animal animal);
  int getNextAnimalId();

  void addAnimalPart(AnimalPart animalPart);
  AnimalPart getAnimalPart(int id);
  int getNextAnimalPartId();

  void addTray(Tray tray);
  Tray getTray(int id);
  int getNextTrayId();
  void addPartToTray(int trayId, int partId);

  void addProduct(Product product);
  int getNextProductId();

  List<Integer> getProductIdsWithAnimalId(int animalId);
  List<Integer> getAnimalIdsFromProductId(int productId);
}
