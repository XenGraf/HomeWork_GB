package homework6;

public class Test {
    public static void main(String[] args) {
        Animal cat0 = new Cat("Пушок");
        Cat cat1 = new Cat("Барсик");
        Dog dog1 = new Dog("Бобик");
        Cat cat2 = new Cat("Мурзик");
        Dog dog2 = new Dog("Барбос");
        cat0.run(500);
        cat1.run(100);
        dog1.swim(10);
        cat2.swim(100);
        dog2.run(500);
        System.out.println(Animal.animalCounter);
        System.out.println(Cat.catCounter);
        System.out.println(Dog.dogCounter);
    }
}
