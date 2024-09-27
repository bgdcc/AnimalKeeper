import java.util.HashSet;
import java.util.HashMap;

// Class describing the characteristics of an accomodation.
abstract class Accomodation {
    // Initializes 2 integers which record the accomodation's maximum population and its current population.
    int maxSize;
    int currentSize;

    HashSet<String> nameList = new HashSet<>();

    // Create a HashSet which tracks the animal types this accomodation is best-suited for.
    HashSet<String> preferredAnimals = new HashSet<>();

    // Adds an animal to the current population.
    void addAnimals() {
        this.currentSize++;
    }

    void subtractAnimals() {
        this.currentSize--;
    }

    // Returns the maximum population this accom
    int getMaxSize() {
        return this.maxSize;
    }

    int getCurrentSize() {
        return this.currentSize;
    }

    void addName(String name) {
        nameList.add(name);
    }

}

class Cage extends Accomodation {
    this.maximumSize = 2;

    
    this.preferredAnimals.add(Lion);
    this.preferredAnimals.add(Tiger);
    this.preferredAnimals.add(Leopard);
    this.preferredAnimals.add(Bear);

}  

class OpenEnclosure extends Accomodation {
    this.maximumSize = 6;
    this.preferredAnimals.add("Lion");
}



