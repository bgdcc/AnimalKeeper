import java.util.ArrayList;
import java.util.HashMap;

public class MyZoo {
    // Initialize an ArrayList which tracks the animal names.
    static ArrayList<String> animalList = new ArrayList<>();

    // Initialize each accomodation.
    Cage home0 = new Cage();
    Cage home1 = new Cage();
    Cage home2 = new Cage();
    Cage home3 = new Cage();
    Cage home4 = new Cage();
    Cage home5 = new Cage();
    Cage home6 = new Cage();
    Cage home7 = new Cage();
    Cage home8 = new Cage();
    Cage home9 = new Cage();

    OpenEnclosure home10 = new OpenEnclosure();
    OpenEnclosure home11 = new OpenEnclosure();
    OpenEnclosure home12 = new OpenEnclosure();
    OpenEnclosure home13 = new OpenEnclosure();
    OpenEnclosure home14 = new OpenEnclosure();

    // Initialize a HashMap which tracks the number of a given home.
    static HashMap<Integer, Accomodation> homeNumbers = new HashMap<>() {
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
    }

    public Hay hay = new Hay();
    public Corn corn = new Corn();
    Grain grain = new Grain();
    Carrots carrots = new Carrots();
    Chicken chicken = new Chicken();
    Beef beef = new Beef();
}
