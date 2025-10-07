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

  @Override public void printAll(){
    System.out.println("=================================================");

    for(Animal animal : animals){
      System.out.println(animal);
    }

    for(AnimalPart animalPart : animalParts){
      System.out.println(animalPart);
    }

    for(Tray tray : trays){
      System.out.println(tray);
    }

    for(Product product : products){
      System.out.println(product);
    }
  }

  @Override public void addAnimal(Animal animal){
    animals.add(animal);
    printAll();
  }

  @Override public Animal getAnimal(int id){
    return null;
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
    printAll();
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
    printAll();
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
    printAll();
  }

  @Override public void addProduct(Product product){
    products.add(product);
    printAll();
  }

  @Override public List<Product> getAllProducts(){
    return List.of();
  }

  @Override public Product getProduct(int id){
    return null;
  }

  @Override public int getNextProductId(){
    int max = 0;
    for(Product product : products){
      if(product.getId() > max) max = product.getId();
    }
    return max + 1;
  }
}
