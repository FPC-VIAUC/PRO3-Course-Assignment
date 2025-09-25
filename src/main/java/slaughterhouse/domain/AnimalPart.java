package slaughterhouse.domain;

public class AnimalPart{

  private int id;
  private int weight;
  private String type;

  public AnimalPart(int id, int weight, String type)
  {
    this.id = id;
    this.weight = weight;
    this.type = type;
  }

  public int getWeight()
  {
    return weight;
  }

  public int getId()
  {
    return id;
  }

  public String getType()
  {
    return type;
  }

  public void setWeight(int weight)
  {
    this.weight = weight;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public void setType(String type)
  {
    this.type = type;
  }
}
