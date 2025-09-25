package domain;

public class HalfAnAnimal extends Product{

  private String type;
  private int amount;

  public HalfAnAnimal(int id, String type, int amount){
    super(id);
    this.type = type;
    this.amount = amount;
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
}
