package domain;

public class Tray{

  private String type;
  private int weightCapacity;

  public Tray(String type, int weightCapacity) {
    this.type = type;
    this.weightCapacity = weightCapacity;
  }

  public String getType()
  {
    return type;
  }

  public int getWeightCapacity()
  {
    return weightCapacity;
  }

  public void setType(String type)
  {
    this.type = type;
  }

  public void setWeightCapacity(int weightCapacity)
  {
    this.weightCapacity = weightCapacity;
  }
}
