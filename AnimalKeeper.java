import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.plugins.tiff.TIFFImageReadParam;

public class AnimalKeeper {

    public ArrayList<String> getInput() {
        // Initialize a Scanner object and an ArrayList representative for the input.
        Scanner scan = new Scanner(System.in);
        ArrayList<String> commandLine = new ArrayList<>();

        // Gets input for the problem.
        while (scan.hasNext()) {
            commandLine.add(scan.nextLine());
        }

        scan.close(); // Closes the scanner.

        // Return the ArrayList.
        return commandLine;
    }

    // Perform actions according to the given input.
    public void run() {

        ArrayList<String> commandLine = getInput();

        /* Initialize a variable which will track the current index.
         * Start reading from index 1 as the first line of the program must always be the same.
         */
        int currentIndex = 1;

        while (currentIndex < commandLine.size()) {
            // Initialize a switch statement which performs commands according to the current ID.
            switch (Integer.valueOf(commandLine.get(currentIndex))) {
                case 0:
                    // Initialize the animal's number ID and its name.
                    int animalID = Integer.valueOf(commandLine.get(currentIndex + 1)); 
                    String animalName = commandLine.get(currentIndex + 2);

                    // Break out of the command if there is another animal with the same name.
                    if (MyZoo.animalList.contains(animalName)) {
                        System.out.println("0!");
                        break;
                    }

                    // Initialize an Animal object according to the previous input.
                    Animal ani;
                    if (animalID == 1) {
                        ani = new Lion(animalName);
                    } else if (animalID == 2) {
                        ani = new Tiger(animalName);
                    } else if (animalID == 3) {
                        ani = new Leopard(animalName);
                    } else if (animalID == 4) {
                        ani = new Zebra(animalName);
                    } else if (animalID == 5) {
                        ani = new Antelope(animalName);
                    } else if (animalID == 6) {
                        ani = new Giraffe(animalName);
                    } else if (animalID == 7) {
                        ani = new Bear(animalName);
                    }

                    int homeID = Integer.valueOf(commandLine.get(currentIndex + 3));
                    int maxCapacity = MyZoo.homeNumbers.get(homeID).getMaxSize();
                    int currentCapacity = MyZoo.homeNumbers.get(homeID).getCurrentSize();

                    // Implement a series of statements which terminate the command if there is anything wrong.
                    if (currentCapacity + 1 > maxCapacity) {
                        System.out.println("0!");
                        currentIndex += 4;
                        break;
                    }

                    if (ani.solitary && currentCapacity > 0) {
                        System.out.println("0!");
                        currentIndex += 4;
                        break;
                    }

                    //...


                case 1:
                case 2:
                    String exiled = commandLine.get(currentIndex + 1);
                    boolean doesItExist = MyZoo.animalList.contains(exiled);

                    for (int i = 0; i < MyZoo.homeNumbers.size(); i++) {
                        if (MyZoo.homeNumbers.get(i).nameList.contains(exiled) && doesItExist) {
                            MyZoo.homeNumbers.get(i).nameList.remove(String.valueOf(exiled));
                            MyZoo.homeNumbers.get(i).subtractAnimals();

                            MyZoo.animalList.remove(String.valueOf(exiled));
                        }
                    }
                case 4:
                case 5:
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new AnimalKeeper().run();
    }
}
