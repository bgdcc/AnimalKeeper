import java.util.ArrayList;

// Class describing the characteristics of an accomodation.
public class Accomodation {

    /* Initializes 2 integers which record 
    *  the accomodation's maximum population and its current population.
    */
    int maxSize;
    int currentSize;

    // Create a ArrayList which stores the name of every animal in the accomodation.
    ArrayList<String> nameList = new ArrayList<>();

    // Create a ArrayList which tracks the animal types this accomodation is best-suited for.
    ArrayList<String> preferredAnimals = new ArrayList<>();

    // Create a ArrayList which stores Animal objects.
    ArrayList<Animal> residents = new ArrayList<>();

    // Adds an animal to the current population.
    public void addAnimals(Animal ani) {
        this.residents.add(ani);
        this.nameList.add(ani.getAnimalName());
        this.currentSize = this.residents.size();
    }

    public void subtractAnimals(Animal ani) {
        this.residents.remove(ani);
        this.nameList.remove(ani.getAnimalName());
        this.currentSize = this.residents.size();
    }

    // Returns the maximum population this accomodation can handle.
    public int retrieveMaxSize() {
        return this.maxSize;
    }


    // Returns the current population of the accomodation.
    public int retrieveCurrentSize() {
        return this.currentSize;
    }

}

class Cage extends Accomodation {
    Cage() {
        this.maxSize = 2;

        this.preferredAnimals.add("Lion");
        this.preferredAnimals.add("Tiger");
        this.preferredAnimals.add("Leopard");
        this.preferredAnimals.add("Bear");
    }

}  

class OpenEnclosure extends Accomodation {
    OpenEnclosure() {
        this.maxSize = 6;

        this.preferredAnimals.add("Lion");
        this.preferredAnimals.add("Tiger");
        this.preferredAnimals.add("Leopard");
        this.preferredAnimals.add("Bear");
        this.preferredAnimals.add("Giraffe");
        this.preferredAnimals.add("Zebra");
        this.preferredAnimals.add("Antelope");
    }
}



