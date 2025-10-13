package slaughterhouse.domain;

import java.util.ArrayList;
import java.util.List;

public class Product{
  private int id;
  private ArrayList<Integer> animalPartIds;

  public Product(int id, List<Integer> productIds)
  {
    this.id = id;
    animalPartIds = new ArrayList<>();
    for(int i = 0; i < productIds.size(); i++)
      addId(productIds.get(i));
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public ArrayList<Integer> getAnimalPartIds(){
    return animalPartIds;
  }

  public void addId(int id)
  {
    animalPartIds.add(id);
  }

  @Override public String toString(){
    return "Product{" + "id=" + id + ", animalPartIds=" + animalPartIds + '}';
  }
}
