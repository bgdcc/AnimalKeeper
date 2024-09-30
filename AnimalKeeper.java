import java.util.ArrayList;
import java.util.Scanner;

class AnimalKeeper {

    public ArrayList<String> getInput() {
        // Initialize a Scanner object and an ArrayList representative for the input.
        Scanner scan = new Scanner(System.in);
        ArrayList<String> commandLine = new ArrayList<>();

        // Gets input in the form of a single string.
        String str = scan.nextLine();

        // Splits the string into its component parts.
        String[] stringArray = str.split(" ");

        for (String i: stringArray) {
            commandLine.add(i);
        }

        scan.close(); // Closes the scanner.

        return commandLine;
    }

    // Perform actions according to the given input.
    public void run() {

        ArrayList<String> commandLine = getInput();

        // Initialize a variable which will track the current index.
        int currentIndex = 0;

        // Initialize a while loop which will go through each command.
        while (currentIndex < commandLine.size()) {
            // Initialize a switch statement which performs commands according to the current ID.
        
            switch (Integer.valueOf(commandLine.get(currentIndex))) {
                case 0:
                    // Initialize the animal's number ID and its name.
                    int animalID = Integer.valueOf(commandLine.get(currentIndex + 1)); 

                    String animalName = commandLine.get(currentIndex + 2);

                    // Break out of the command if there is another animal with the same name.
                    if (MyZoo.animalNameList.contains(animalName)) {
                        System.out.println("0!");
                        currentIndex += 4;
                        break;
                    }

                    Animal ani;

                    // Initialize an Animal object according to the previous input.
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
                    } else {
                        System.out.print("0!");
                        currentIndex += 4;
                        break;
                    }

                    // Initialize the home's number.
                    int homeID = Integer.valueOf(commandLine.get(currentIndex + 3));

                    // Store the maximum and current capacity in different variables.
                    int maxCapacity = MyZoo.houseNumbers().get(homeID).retrieveMaxSize();
                    int currentCapacity = MyZoo.houseNumbers().get(homeID).retrieveCurrentSize();

                    // Break the command if there does not exist any spare space for the new animal.
                    if (currentCapacity + 1 > maxCapacity) {
                        System.out.println("0!");
                        currentIndex += 4;
                        break;
                    } 

                    /* Break the command if the animal prefers not to live 
                    *  in a group and the current population is more than 0.
                    */
                    if (ani.isSolitary() && currentCapacity > 0) {
                        System.out.println("0!");
                        currentIndex += 4;
                        break;
                    }

                    // Break the command if the residence is not suited for the animal.
                    if (!MyZoo.houseNumbers().get(homeID).preferredAnimals.
                        contains(ani.getClassName())) {

                        System.out.println("0!");
                        currentIndex += 4;
                        break;
                    }

                    // Store the animal's diet type and prospective future neighbours in variables.
                    String anisDiet = ani.getDietType();
                    ArrayList<Animal> residentsFromHomeID = 
                                       MyZoo.houseNumbers().get(homeID).residents;

                    /* Initialize a boolean value which will facilitate
                     * breaking out of the program during loops.
                    */
                    boolean didItBreak = false;

                    // Checks to see if the accomodation contains animals with other diet types.
                    if (residentsFromHomeID.size() > 0) {
                        for (Animal resident: residentsFromHomeID) {
                            if (!resident.getDietType().equals(anisDiet)) {
                                System.out.println("0!");
                                currentIndex += 4;
                                didItBreak = true;
                                break;
                            }
                        }

                        if (didItBreak) {
                            break;
                        }
                    }

                    // Resets the value of the intermediary variable.

                    didItBreak = false;

                    /* As Carnivores and Omnivores can only live with the same species,
                    *  check to see if there are any other animal types in the prospective home.
                    */
                    if ((ani.getDietType().equals("Omnivore") 
                         || ani.getDietType().equals("Carnivore")) 
                         && residentsFromHomeID.size() > 0) {

                        for (Animal resident: residentsFromHomeID) {
                            if (!resident.getClassName().equals(ani.getClassName())) {
                                System.out.println("0!");
                                currentIndex += 4;
                                didItBreak = true;
                                break;
                            }
                        }

                        if (didItBreak) {
                            break;
                        }
                    }

                    /* Add the animal to the accomodation if there is no previous criteria which would indicate otherwise.*/
                    MyZoo.houseNumbers().get(homeID).addAnimals(ani);
                    MyZoo.animalList.add(ani);
                    MyZoo.animalNameList.add(ani.getAnimalName());
                    System.out.print("0");
                    currentIndex += 4;
                    break;

                case 1:
                    // Implements a method which allows the user to move the animal from one home to another.

                    String onTheMove = commandLine.get(currentIndex + 1);
                    int newHomeID = Integer.valueOf(commandLine.get(currentIndex + 2));
                    Accomodation newHome = MyZoo.houseNumbers().get(newHomeID);

                    boolean theAnimalExists = true;
                    int newIndex = -1;

                    Animal ani1;

                    for (int i = 0; i < MyZoo.animalList.size(); i++) {
                        if (MyZoo.animalList.get(i).getAnimalName().equals(onTheMove)) {
                            newIndex = i;
                            break;
                        }

                        if (i == MyZoo.animalList.size() - 1) {
                            theAnimalExists = false;
                        }
                    }

                    if (!theAnimalExists) {
                        currentIndex += 3;
                        break;
                    }

                    ani1 = MyZoo.animalList.get(newIndex);

                    if (!newHome.preferredAnimals.contains(ani1.getClassName())) {
                        System.out.println("1!");
                        currentIndex += 3;
                        break;
                    }

                    if (newHome.retrieveMaxSize() < newHome.retrieveCurrentSize() + 1) {
                        System.out.println("1!");
                        currentIndex += 3;
                        break;
                    }

                    // Keep track of whether a certain action has been performed or not.
                    boolean breakOut = false;

                    if (newHome.retrieveCurrentSize() > 0) {
                        for (Animal resident: newHome.residents) {
                            if (!resident.getDietType().equals(ani1.getDietType())) {
                                System.out.print("1!");
                                currentIndex += 3;

                                breakOut = true;

                                break;
                            }
                        }

                        if (breakOut) {
                            break;
                        }
                    }

                    breakOut = false;

                    if (ani1.getClassName().equals("Carnivore") 
                        || ani1.getClassName().equals("Omnivore")
                        && newHome.retrieveCurrentSize() > 0) {
                        for (Animal resident: newHome.residents) {
                            if (!resident.getClassName().equals(ani1.getClassName())) {
                                System.out.print("1!");
                                currentIndex += 3;

                                breakOut = true;

                                break;
                            }
                        }

                        if (breakOut) {
                            break;
                        }
                    }

                    // Find the Animal's former home and remove it from there.
                    for (int i = 0; i < MyZoo.houseNumbers().size(); i++) {
                        if (MyZoo.houseNumbers().get(i).residents.contains(ani1)) {
                            MyZoo.houseNumbers().get(i).residents.remove(ani1);
                        }
                    }

                    newHome.addAnimals(ani1);
                    System.out.println("1");
                    currentIndex += 3;
                    break;


                    
                case 2: 
                    // Implements a method which allows the user to delete an animal from the farm.
                    breakOut = false;
                    /* Tracks the name of the animal waiting 
                    *  to be removed and stores it into a variable.
                    */
                    Animal ani2;
                    int newerIndex = -1;

                    // Stores the Animal's name into a variable.
                    String exiled = commandLine.get(currentIndex + 1);

                    // Finds the Animal in animalList.
                    for (int i = 0; i < MyZoo.animalList.size(); i++) {
                        if (MyZoo.animalList.get(i).getAnimalName().equals(exiled)) {
                            newerIndex = i;
                        }
                    }

                    if (newerIndex < 0) {
                        System.out.println("2!");
                        currentIndex += 2;
                        break;
                    }

                    ani2 = MyZoo.animalList.get(newerIndex);

                    // Checks if the name has been deleted.
                    boolean hasItBeenDone = false;

                    for (int i = 0; i < MyZoo.houseNumbers().size(); i++) {
                        if (MyZoo.houseNumbers().get(i).residents.contains(ani2)) {
                            // Remove the Animal from MyZoo and its own home's databases.
                            MyZoo.houseNumbers().get(i).subtractAnimals(ani2);
                            MyZoo.exileAnimal(ani2);

                            hasItBeenDone = true;
                            break;
                        }
                    }

                    if (!hasItBeenDone) {
                        System.out.print("2!");
                        currentIndex += 2;
                        break;
                    }

                    System.out.print("2");
                    currentIndex += 2;
                    break;

                case 3:
                    int foodID = Integer.valueOf(commandLine.get(currentIndex + 1));
                    Food currentFood;

                    int amount = Integer.valueOf(commandLine.get(currentIndex + 2));

                    if (foodID == 1) {
                        currentFood = MyZoo.hay;
                    } else if  (foodID == 2) {
                        currentFood = MyZoo.corn;
                    } else if  (foodID == 3) {
                        currentFood = MyZoo.grain;
                    } else if  (foodID == 4) {
                        currentFood = MyZoo.carrots;
                    } else if  (foodID == 5) {
                        currentFood = MyZoo.chicken;
                    } else if  (foodID == 6) {
                        currentFood = MyZoo.beef;
                    } else {
                        System.out.print("3!");
                        currentIndex += 3;
                        break;
                    }
                    
                    if (currentFood.inspectFood(amount)) {
                        currentFood.addFood(amount);
                        System.out.print("3");
                        currentIndex += 3;
                        break;
                    }

                    System.out.print("3!");
                    currentIndex += 3;
                    break;
                    

                case 4:
                    int typeOfFood = Integer.valueOf(commandLine.get(currentIndex + 1));
                    int amountToFeed = Integer.valueOf(commandLine.get(currentIndex + 2));
                    int selectedHomeID = Integer.valueOf(commandLine.get(currentIndex + 3));

                    Food newFood;

                    if (typeOfFood == 1) {
                        newFood = MyZoo.hay;
                    } else if  (typeOfFood == 2) {
                        newFood = MyZoo.corn;
                    } else if  (typeOfFood == 3) {
                        newFood = MyZoo.grain;
                    } else if  (typeOfFood == 4) {
                        newFood = MyZoo.carrots;
                    } else if  (typeOfFood == 5) {
                        newFood = MyZoo.chicken;
                    } else if  (typeOfFood == 6) {
                        newFood = MyZoo.beef;
                    } else {
                        System.out.print("4!");
                        currentIndex += 4;
                        break;
                    }

                    if (newFood.getCurrentCapacity() < amountToFeed) {
                        System.out.print("4!");
                        currentIndex += 4;
                        break;
                    }

                    Accomodation selectedHome = MyZoo.houseNumbers().get(selectedHomeID);

                    int suitableAnimals = 0;

                    for (Animal resident: selectedHome.residents) {
                        if (resident.getAllowedFood().contains(newFood.getName())) {
                            suitableAnimals++;
                        }
                    }

                    if (suitableAnimals < amountToFeed) {
                        System.out.print("4!");
                        currentIndex += 4;
                        break;
                    }

                    newFood.feedHome(amountToFeed);

                    System.out.print("4");
                    currentIndex += 4;
                    break;

                default:
                    currentIndex = commandLine.size() + 1;
                    break;
            }

            if (currentIndex < commandLine.size()) {
                System.out.print(" ");
            }
        }

        System.out.println("");

    }

    public static void main(String[] args) throws Exception {
        new AnimalKeeper().run();
    }
}
