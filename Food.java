abstract class Food {
    private String name = new String();
    private final int maxCapacity;
    private int currentCapacity;

    public Food(String name) {
        this.name = name;
        this.maxCapacity = 100;
        this.currentCapacity = 0;
    }

    // Implementing buyFood method; for command 3
    int buyFood(int amount) {
        if (currentCapacity + amount > maxCapacity) {
            return 0;
        }

        currentCapacity += amount;
        return 1;
    }

    // Implementing method feedHome; for command 4

    int feedHome(int amountTofeed, Accomodation foodDestination) {
        currentCapacity -= amountTofeed;


        return 0;

    }

    public String getName() {
        return this.name;
    }

    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    public int getCurrentCapacity() {
        return this.currentCapacity;
    }

}

class Hay extends Food {
    public Hay() {
        super("Hay");
    }


}

class Corn extends Food {
    public Corn() {
        super("Corn");
    }

}

class Grain extends Food {
    public Grain() {
        super("Grain");
    }

}

class Carrots extends Food {
    public Carrots() {
        super("Carrots");
    }

}

class Chicken extends Food {
    public Chicken() {
        super("Chicken");
    }

}

class Beef extends Food {
    public Beef() {
        super("Beef");
    }

}


