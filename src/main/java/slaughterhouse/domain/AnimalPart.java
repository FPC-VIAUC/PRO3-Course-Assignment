package slaughterhouse.domain;

public class AnimalPart{

  private int id;
  private int weight;
  private String type;
  private int animalId;

  public AnimalPart(int id, int weight, String type, int animalId)
  {
    this.id = id;
    this.weight = weight;
    this.type = type;
    this.animalId = animalId;
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

  public int getAnimalId(){
    return animalId;
  }

  public void setAnimalId(int animalId){
    this.animalId = animalId;
  }
}
