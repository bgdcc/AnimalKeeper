import java.util.HashSet;
import java.util.HashMap;

abstract class Accomodation {
    int maxSize;
    int currentPopulation = 0;



    HashSet<Animal> preferredAnimals;

    void addAnimals() {
        this.currentPopulation++;
    }
}
