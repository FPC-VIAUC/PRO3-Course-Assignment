package slaughterhouse.domain;

public class Animal{
  private int id;
  private int weight;

  public Animal(int id, int weight)
  {
    this.id = id;
    this.weight = weight;
  }

  public int getId()
  {
    return id;
  }

  public int getWeight()
  {
    return weight;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public void setWeight(int weight)
  {
    this.weight = weight;
  }
}
