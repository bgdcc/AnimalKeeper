import java.util.ArrayList;
import java.util.HashMap;


abstract class Animal {
    // Initialize variables for name and allowed food.
    private String name = new String();
    private ArrayList<String> allowedFood = new ArrayList<>();

    // Declare a variable which will store the animal type as a String.
    private String typeString = new String();

    // Initialize  HashMap which correlates the designated number with the animal.
    static HashMap<Integer, Animal> animalTypes = new HashMap<>(); 

    animalTypes.put(1, new Lion());
    // animalTypes.put(2, Tiger);
    // animalTypes.put(3, Leopard);
    // animalTypes.put(4, Zebra);
    // animalTypes.put(5, Antelope);
    // animalTypes.put(6, Giraffe);
    // animalTypes.put(7, Bear);

    // Initialize an ArrayList which tracks other type of animals the animal can live with.
    ArrayList<Animal> allowedTypes = new ArrayList<>();

    // Initialize a boolean variable and method which check if the animal likes to live in a group.
    boolean solitary = false;
    
    Animal(String name) {
        this.name = name;
    } 

    String getString() {
        return this.name;
    }

    ArrayList<String> getAllowedFood() {
        return this.allowedFood;
        
    }

    ArrayList<String> setAllowedFood(String food) {
        this.getAllowedFood().add(food);
    }
}

class Herbivore extends Animal {

    Herbivore(String name) {
        super(name);
        this.setAllowedFood(new Hay().getName());
        this.setAllowedFood(new Corn().getName());
        this.setAllowedFood(new Grain().getName());
        this.setAllowedFood(new Carrots().getName());
    }
}

class Carnivore extends Animal {
    Carnivore(String name) {
        super(name);
    }
}

class Omnivore extends Animal {
    Omnivore(String name) {
        super(name);
    }
}

class Lion extends Carnivore {
    Lion(String name) {
        super(name);
    }
}

class Tiger extends Carnivore {
    Tiger(String name) {
        super(name);
        
    }
}

class Leopard extends Carnivore {
    Leopard(String name) {
        super(name);
    }
}

class Zebra extends Herbivore {
    Zebra(String name) {
        super(name);
    }
}

class Antelope extends Herbivore {
    Antelope(String name) {
        super(name);
    }

    this.setAllowedFood
}

class Giraffe extends Herbivore {
    Giraffe(String name) {
        super(name);
    }
}

class Bear extends Omnivore {
    Bear(String name) {
        super(name);
    }
}
