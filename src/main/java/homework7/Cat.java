package homework7;

public class Cat {
    private String name;
    private int appetite;
    private boolean fullness;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.fullness = false;
    }

    public void eat(Plate p) {
        if (appetite <= p.getFood()) {
            p.decreaseFood(appetite);
            fullness = true;
        }
        else {
            System.out.println("There is no enough food in this plate for " + name);
        }

    }

    public boolean isFullness() {
        return fullness;
    }

    public String getName() {
        return name;
    }
}

