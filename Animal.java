import java.util.ArrayList;

// Initializing abstract class Animal which will not be instantiated.
abstract class Animal {
    // Initialize variables for name, allowed food and dietType.
    private String name = new String();
    private ArrayList<String> allowedFood = new ArrayList<>();
    private String dietType = new String();
    // Initialize a boolean variable and method which check if the animal likes to live in a group.
    private boolean solitary;
    private String className;


    // Animal default constructor with no parameters.
    Animal() {

    }

    // Animal constructor that initializes name field
    Animal(String name) {
        this.name = name;
    } 

    // Initialize an ArrayList which tracks other type of animals the animal can live with.
    // private ArrayList<Animal> allowedTypes = new ArrayList<>();


    //Getters and Setters for Animal fields 
    public String getAnimalName() {
        return this.name;
    }

    public ArrayList<String> getAllowedFood() {
        return this.allowedFood;
        
    }

    public void setAllowedFood(String food) {
        this.getAllowedFood().add(food);

    }

    public String getDietType() {
        return this.dietType;
    }

    public void setDietType(String dietType) {
        this.dietType = dietType;
    }

    public boolean isSolitary() {
        return this.solitary;
    }

    public void setSolitary(boolean solitary) {
        this.solitary = solitary;
    }

    public void setClassName(String theClass) {
        this.className = theClass;
    }

    public String getClassName() {
        return this.className;
    }
}

// Initializing dietTypes that inherit from superclass Animal
/*
 * 
 */
class Herbivore extends Animal {
    Herbivore() {
        this.setAllowedFood(new Hay().getName());
        this.setAllowedFood(new Corn().getName());
        this.setAllowedFood(new Grain().getName());
        this.setAllowedFood(new Carrots().getName());
        this.setDietType("Herbivore");
    }

    Herbivore(String name) {
        super(name);
        this.setAllowedFood(new Hay().getName());
        this.setAllowedFood(new Corn().getName());
        this.setAllowedFood(new Grain().getName());
        this.setAllowedFood(new Carrots().getName());
        this.setDietType("Herbivore");


    }   

}


class Carnivore extends Animal {
    Carnivore() {
        this.setAllowedFood(new Chicken().getName());
        this.setAllowedFood(new Beef().getName());
        this.setDietType("Carnivore");

    }

    Carnivore(String name) {
        super(name);
        this.setAllowedFood(new Chicken().getName());
        this.setAllowedFood(new Beef().getName());
        this.setDietType("Carnivore");
    }


}

class Omnivore extends Animal {
    Omnivore() {
        this.setAllowedFood(new Carrots().getName());
        this.setAllowedFood(new Chicken().getName());
        this.setAllowedFood(new Beef().getName());
        this.setDietType("Omnivore");

    }

    Omnivore(String name) {
        super(name);
        this.setAllowedFood(new Carrots().getName());
        this.setAllowedFood(new Chicken().getName());
        this.setAllowedFood(new Beef().getName());
        this.setDietType("Omnivore");
    }
}




class Lion extends Carnivore {
    Lion(String name) {
        super(name);
        setClassName("Lion");
        setSolitary(false);
    }
}

class Tiger extends Carnivore {
    Tiger(String name) {
        super(name);
        setClassName("Tiger");
        setSolitary(true);
        
    }
}

class Leopard extends Carnivore {
    Leopard(String name) {
        super(name);
        setClassName("Leopard");
        setSolitary(true);

    }

}

class Zebra extends Herbivore {
    Zebra(String name) {
        super(name);
        setClassName("Zebra");
        setSolitary(false);
    }

}

class Antelope extends Herbivore {

    Antelope(String name) {
        super(name);
        // Override Herbivore construct to make sure Antelopes don't eat carrots
        this.getAllowedFood().remove(new Carrots().getName());
        setSolitary(false);
        setClassName("Antelope");
    }


}

class Giraffe extends Herbivore {
    Giraffe(String name) {
        super(name);
        setSolitary(false);
        setClassName("Giraffe");
    }

}

class Bear extends Omnivore {
    Bear(String name) {
        super(name);
        setSolitary(true);
        setClassName("Bear");
    }


}