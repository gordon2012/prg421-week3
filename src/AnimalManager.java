import java.util.*;
import java.io.*;

public class AnimalManager
{
  private static final AnimalManager instance = new AnimalManager();
  private List<Animal> animals;

  private AnimalManager()
  {
    animals = new ArrayList<Animal>();
  }

  public static final AnimalManager getInstance()
  {
    return instance;
  }

  public String toString()
  {
    String out = "";
    ListIterator itr = animals.listIterator();
    while(itr.hasNext())
    {
      out += (itr.nextIndex()+1) + " - " + itr.next().toString() + "\n";
    }
    return out;
  }

  public void add(Animal animal)
  {
    animals.add(animal);
    save();
  }

  public boolean remove(int index)
  {
    boolean success = true;

    if(index > 0)
    {
      try
      {
        animals.remove(index-1);
        save();
      }
      catch(IndexOutOfBoundsException e)
      {
        success = false;
      }
    }

    return success;
  }


  public void load()
  {
    animals.clear();
    Animal a;

    try(FileInputStream fileIn = new FileInputStream("data.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn))
    {
      do
      {
        a = (Animal) in.readObject();
        if(a != null)
        {
          animals.add(a);
        }
      }
      while(a != null);
    }
    catch(FileNotFoundException e) {}
    catch(EOFException e) {}
    catch(IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  public void save()
  {
    try(FileOutputStream fileOut = new FileOutputStream("data.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut))
    {
      for(Animal animal : animals)
      {
        out.writeObject(animal);
      }
    }
    catch(IOException e)
    {
      e.printStackTrace();
    }
  }
}
