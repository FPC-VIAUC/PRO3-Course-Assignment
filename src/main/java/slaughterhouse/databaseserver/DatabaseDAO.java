package slaughterhouse.databaseserver;

import slaughterhouse.domain.Animal;
import slaughterhouse.domain.AnimalPart;
import slaughterhouse.domain.Product;

import java.util.List;

public interface DatabaseDAO{
  void addAnimal(Animal animal);
  int getNextAnimalId();

  void addAnimalPart(AnimalPart animalPart);
  int getNextAnimalPartId();

  int createTray();
  void addPartToTray(int trayId, int partId);

  void addProduct(Product product);
  int getNextProductId();

  List<Integer> getProductIdsWithAnimalId(int animalId);
  List<Integer> getAnimalIdsFromProductId(int productId);
}
