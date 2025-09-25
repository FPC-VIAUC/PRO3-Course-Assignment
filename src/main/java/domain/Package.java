package domain;

public class Package extends Product{
  private String animalType;

  public Package(int id, String animalType){
    super(id);
    this.animalType = animalType;
  }

  public String getAnimalType()
  {
    return animalType;
  }

  public void setAnimalType(String animalType)
  {
    this.animalType = animalType;
  }
}
