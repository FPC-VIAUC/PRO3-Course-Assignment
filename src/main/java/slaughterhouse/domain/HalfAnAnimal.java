package slaughterhouse.domain;

import java.util.List;

public class HalfAnAnimal extends Product{

  private String type;
  private int amount;

  public HalfAnAnimal(int id, List<Integer> productIds){
    super(id);
    for(int i = 0; i < productIds.size(); i++)
      super.addId(productIds.get(i));
  }

  public String getType()
  {
    return type;
  }

  public void setType(String type)
  {
    this.type = type;
  }

  public int getAmount()
  {
    return amount;
  }

  public void setAmount(int amount)
  {
    this.amount = amount;
  }

  @Override public String toString(){
    return "HalfAnAnimal{" + "type='" + type + '\'' + ", amount=" + amount
        + '}';
  }
}
