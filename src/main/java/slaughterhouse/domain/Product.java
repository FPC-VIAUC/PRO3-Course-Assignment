package slaughterhouse.domain;

import java.util.ArrayList;

public class Product{
  private int id;
  private ArrayList<Integer> animalPartIds;

  public Product(int id)
  {
    this.id = id;
    animalPartIds = new ArrayList<>();
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public void addId(int id)
  {
    animalPartIds.add(id);
  }
}
