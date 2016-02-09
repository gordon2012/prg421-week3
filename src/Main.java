// Iterator Program
// Gordon Doskas
// PRG/421
// February 8, 2016
// Roland Morales

// This program allows for the manipulation of animal objects that each contain the
// properties of number of legs, arms, and tails; and whether or not they burrow,
// swim, and fly.
//
// A menu system allows for the users to add an animal, inputing these properties
// (for the bools, a y or Y indicates true, all others false). It also allows
// animals to be deleted.
//
// The list of animals is saved in a file called data.ser


import java.io.*;

public class Main
{
  public static void main(String[] args)
  {
    UI ui = UI.getInstance();
    AnimalManager animalManager = AnimalManager.getInstance();
    animalManager.load();

    int menu = 0;
    do
    {
      ui.print("[1] List Animals\n[2] Add Animal\n[3] Remove Animal\n[X] Exit\n");

      switch(ui.getInput("").substring(0).toUpperCase())
      {
        case "1":
          ui.print("\n");
          ui.print(animalManager);
          ui.print("\n");
          break;

        case "2":
          ui.print("\n");
          animalManager.add(new Animal
          (
            ui.getInput("Name"),
            ui.getInt("# of Legs"),
            ui.getInt("# of Arms"),
            ui.getInt("# of Tails"),
            ui.getBool("Burrows[y/N]"),
            ui.getBool("Swims[y/N]"),
            ui.getBool("Flies[y/N]")
          ));
          ui.print("\n");
          break;

        case "3":
          ui.print("\nWhich one? (0 to cancel)\n");
          ui.print(animalManager);
          while(!animalManager.remove(ui.getInt(""))); // gets user input until valid
          ui.print("\n");
          break;

        case "X":
          menu = -1;
          break;
      }
    }
    while(menu != -1);
  }
}
