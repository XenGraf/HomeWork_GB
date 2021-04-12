package homework6;

public abstract class Animal {
    String name;
    static int animalCounter;

    public Animal() {
        animalCounter++;
    }

    public Animal(String name) {
        this.name = name;
    }

    abstract void swim(int lengthFence);

    abstract void run(int lengthFence);


}
