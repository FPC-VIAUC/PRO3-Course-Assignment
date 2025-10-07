package slaughterhouse.databaseserver;

import slaughterhouse.domain.*;

import java.util.ArrayList;
import java.util.List;

public class ArrayDatabase implements DatabaseDAO{
  private ArrayList<Animal> animals;
  private ArrayList<AnimalPart> animalParts;
  private ArrayList<Tray> trays;
  private ArrayList<Product> products;

  public ArrayDatabase(){
    animals = new ArrayList<>();
    animalParts = new ArrayList<>();
    trays = new ArrayList<>();
    products = new ArrayList<>();
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

  @Override public void addAnimalPart(AnimalPart animalPart){
    animalParts.add(animalPart);
  }

  @Override public AnimalPart getAnimalPart(int id){
    for(AnimalPart animalPart : animalParts){
      if(animalPart.getId() == id) return animalPart;
    }
    return null;
  }

  @Override public int getNextAnimalPartId(){
    int max = 0;
    for(AnimalPart animalPart : animalParts){
      if(animalPart.getId() > max) max = animalPart.getId();
    }
    return max + 1;
  }

  @Override public void addTray(Tray tray){
    trays.add(tray);
  }

  @Override public Tray getTray(int id){
    for(Tray tray : trays){
      if(tray.getId() == id) return tray;
    }
    return null;
  }

  @Override public int getNextTrayId(){
    int max = 0;
    for(Tray tray : trays){
      if(tray.getId() > max) max = tray.getId();
    }
    return max + 1;
  }

  @Override public void addPartToTray(int trayId, int partId){
    Tray tray = getTray(trayId);
    tray.addAnimalPartId(partId);
  }

  @Override public void addProduct(Product product){
    throw new UnsupportedOperationException();
  }

  @Override public int getNextProductId(){
    throw new UnsupportedOperationException();
  }

  @Override public List<Integer> getProductIdsWithAnimalId(int animalId){
    throw new UnsupportedOperationException();
  }

  @Override public List<Integer> getAnimalIdsFromProductId(int productId){
    throw new UnsupportedOperationException();
  }
}
