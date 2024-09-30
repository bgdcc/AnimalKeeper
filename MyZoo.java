import java.util.ArrayList;
import java.util.HashMap;

abstract class MyZoo {
    // Initialize an ArrayList which tracks the animal names.
    static ArrayList<String> animalNameList = new ArrayList<>();
    static ArrayList<Animal> animalList = new ArrayList<>();

    // Initialize each accomodation.
    static Cage home0 = new Cage();
    static Cage home1 = new Cage();
    static Cage home2 = new Cage();
    static Cage home3 = new Cage();
    static Cage home4 = new Cage();
    static Cage home5 = new Cage();
    static Cage home6 = new Cage();
    static Cage home7 = new Cage();
    static Cage home8 = new Cage();
    static Cage home9 = new Cage();

    static OpenEnclosure home10 = new OpenEnclosure();
    static OpenEnclosure home11 = new OpenEnclosure();
    static OpenEnclosure home12 = new OpenEnclosure();
    static OpenEnclosure home13 = new OpenEnclosure();
    static OpenEnclosure home14 = new OpenEnclosure();

    // Initialize a HashMap which tracks the number of a given home.


    public static HashMap<Integer, Accomodation> houseNumbers() {
        HashMap<Integer, Accomodation> homeNumbers = new HashMap<>();

        homeNumbers.put(0, home0);
        homeNumbers.put(1, home1);
        homeNumbers.put(2, home2);
        homeNumbers.put(3, home3);
        homeNumbers.put(4, home4);
        homeNumbers.put(5, home5);
        homeNumbers.put(6, home6);
        homeNumbers.put(7, home7);
        homeNumbers.put(8, home8);
        homeNumbers.put(9, home9);
        homeNumbers.put(10, home10);
        homeNumbers.put(11, home11);
        homeNumbers.put(12, home12);
        homeNumbers.put(13, home13);
        homeNumbers.put(14, home14);

        return homeNumbers;
    }

    static Hay hay = new Hay();
    static Corn corn = new Corn();
    static Grain grain = new Grain();
    static Carrots carrots = new Carrots();
    static Chicken chicken = new Chicken();
    static Beef beef = new Beef();

    // Permamnently remove an Animal from the Zoo.
    static void exileAnimal(Animal ani) {
        animalNameList.remove(ani.getAnimalName());
        animalList.remove(ani);
        
    }
}
