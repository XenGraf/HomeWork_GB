package homework6;


public class Dog extends Animal {

    static int dogCounter;

    public Dog(String name) {
        this.name = name;
        this.dogCounter++;
    }

    public void dogInfo() {
        System.out.println("Собака имя: " + name);
    }

    @Override
    public void run(int lengthFence) {
            if (lengthFence <= 500) {
                System.out.println(name + " пробежал " + lengthFence + " м ");
            }
            else {
                System.out.println(" Слишком длинная дистанция для собаки ");
            }
    }
    @Override
    public void swim(int lengthFence) {
        if (lengthFence <= 10) {
            System.out.println(name + " проплыл " + lengthFence + " м ");
        }
        else {
            System.out.println(" Слишком длинная дистанция для собаки ");
        }
    }

}
