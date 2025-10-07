package slaughterhouse.databaseserver;

import slaughterhouse.domain.*;

import java.util.List;

public interface DatabaseDAO{
  void addAnimal(Animal animal);
  Animal getAnimal(int id);
  int getNextAnimalId();

  void addAnimalPart(AnimalPart animalPart);
  AnimalPart getAnimalPart(int id);
  int getNextAnimalPartId();

  void addTray(Tray tray);
  Tray getTray(int id);
  int getNextTrayId();
  void addPartToTray(int trayId, int partId);

  void addProduct(Product product);
  List<Product> getAllProducts();
  Product getProduct(int id);
  int getNextProductId();
}
