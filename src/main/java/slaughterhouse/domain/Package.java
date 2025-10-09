package slaughterhouse.domain;

import java.util.List;

public class Package extends Product{
  private String animalType;
  private int amount;

  public Package(int id, List<Integer> animalPartIds, String animalType, int amount){
    super(id, animalPartIds);
    this.animalType = animalType;
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

  @Override public String toString(){
    return "Package{" + "animalType='" + animalType + '\'' + ", amount="
        + amount + '}';
  }
}
