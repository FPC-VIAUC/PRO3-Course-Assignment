package slaughterhouse.domain;

public class Package extends Product{
  private String animalPartType;
  private int amount;

  public Package(int id, String animalPartType, int amount){
    super(id);
    this.animalPartType = animalPartType;
    this.amount = amount;
  }

  public String getAnimalPartType()
  {
    return animalPartType;
  }

  public void setAnimalPartType(String animalPartType)
  {
    this.animalPartType = animalPartType;
  }

  public int getAmount(){
    return amount;
  }

  public void setAmount(int amount){
    this.amount = amount;
  }
}
