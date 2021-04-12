package homework6;

public class Cat extends Animal {
    String name;
    static int catCounter;

    public Cat(String name) {
        this.name = name;
        this.catCounter++;
    }

    public void catInfo() {
        System.out.println("Кот имя: " + name);
    }

    @Override
    public void run(int lengthFence) {
        if (lengthFence <= 200) {
            System.out.println(name + " пробежал " + lengthFence + " м ");
        } else {
            System.out.println("Слишком длинная дистанция для кота ");
        }
    }

    @Override
    public void swim(int lengthFence) {
        System.out.println(name + " не умеет плавать  ");
    }

}
