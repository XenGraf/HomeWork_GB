package hw7;

public class Test {





    public static void main(String[] args) {





        Cat[] cats = new Cat[5];


        cats[0] = new Cat("Barsik",25);


        cats[1] = new Cat("Pushok", 15);


        cats[2] = new Cat("Garfild", 10);


        cats[3] = new Cat("Begemot", 35);


        cats[4] = new Cat("Tom",20);





        Plate plate = new Plate(100);


        plate.info();


        for (Cat cat: cats) {


            cat.eat(plate);


        }





        for (Cat cat: cats) {


            if (cat.isFullness()) {


                System.out.println(cat.getName()+ " is full");


            } else {System.out.println(cat.getName()+ " is hungry");


            }


        }


        plate.info();





        plate.increaseFood(20);


        plate.info();


        cats[4].eat(plate);


        if (cats[4].isFullness()) {


            System.out.println(cats[4].getName()+ " is full");



        } else {



            System.out.println(cats[4].getName()+ " is hungry");



        }







    }







}

