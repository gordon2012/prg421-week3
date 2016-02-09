public class Animal implements java.io.Serializable
{
  String name;
  int legs;
  int arms;
  int tails;
  boolean burrow;
  boolean swim;
  boolean fly;

  Animal(String name, int legs, int arms, int tails, boolean burrow, boolean swim, boolean fly)
  {
    this.name = name;
    this.legs = legs;
    this.arms = arms;
    this.tails = tails;
    this.burrow = burrow;
    this.swim = swim;
    this.fly = fly;
  }

  public String toString()
  {
    return(name + ": " +
      legs + (legs == 1 ? " leg, " : " legs, ") +
      arms + (arms == 1 ? " arm, " : " arms, ") +
      tails + (tails == 1 ? " tail, " : " tails, ") +
      (burrow ? "burrows, " : "cannot burrow, ") +
      (swim ? "swims, " : "cannot swim, ") +
      (fly ? "flies." : "cannot fly."));
  }

  public String getName()
  {
    return name;
  }

  public int getLegs()
  {
    return legs;
  }

  public int getArms()
  {
    return arms;
  }

  public int getTails()
  {
    return tails;
  }

  public boolean getBurrow()
  {
    return burrow;
  }

  public boolean getSwim()
  {
    return swim;
  }

  public boolean getFly()
  {
    return fly;
  }
}
