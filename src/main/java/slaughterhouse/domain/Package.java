package slaughterhouse.domain;

public class Package extends Product{
  private String animalType;
  private int amount;

  public Package(int id, String animalPartType, int amount){
    super(id);
    this.animalType = animalPartType;
    this.amount = amount;
  }

  public String getAnimalType()
  {
    return animalType;
  }

  public void setAnimalType(String animalType)
  {
    this.animalType = animalType;
  }
  public int getAmount(){
    return amount;
  }

  public void setAmount(int amount){
    this.amount = amount;
  }
}
