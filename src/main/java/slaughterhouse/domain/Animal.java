package slaughterhouse.domain;

import java.time.LocalDate;

public class Animal{
  private int id;
  private int weight;
  private String origin;
  private LocalDate date;

  public Animal(int id, int weight, String origin, LocalDate date)
  {
    this.id = id;
    this.weight = weight;
    this.origin = origin;
    this.date = date;
  }

  public int getId()
  {
    return id;
  }

  public int getWeight()
  {
    return weight;
  }

  public String getOrigin()
  {
    return origin;
  }

  public LocalDate getDate()
  {
    return date;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public void setWeight(int weight)
  {
    this.weight = weight;
  }

  public void setOrigin(String origin)
  {
    this.origin = origin;
  }

  public void setDate(LocalDate date)
  {
    this.date = date;
  }

  @Override public String toString(){
    return "Animal{" + "id=" + id + ", weight=" + weight + ", origin=" + origin + ", registration date=" + date + '}';
  }
}
