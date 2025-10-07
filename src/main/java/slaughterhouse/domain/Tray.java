package slaughterhouse.domain;

import java.util.ArrayList;

public class Tray{

  private int id;
  private String type;
  private int weightCapacity;
  private ArrayList<Integer> animalPartIds;

  public Tray(int id, String type, int weightCapacity) {
    this.id  = id;
    this.type = type;
    this.weightCapacity = weightCapacity;
    animalPartIds = new ArrayList<>();
  }

  public int getId(){
    return id;
  }

  public void setId(int id){
    this.id = id;
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

  public void setWeightCapacity(int weightCapacity){
    this.weightCapacity = weightCapacity;
  }

  public ArrayList<Integer> getAnimalPartIds(){
    return animalPartIds;
  }

  public void addAnimalPartId(int id){
    animalPartIds.add(id);
  }

  @Override public String toString(){
    return "Tray{" + "id=" + id + ", type='" + type + '\'' + ", weightCapacity="
        + weightCapacity + ", animalPartIds=" + animalPartIds + '}';
  }
}
