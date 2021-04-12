package homework5;

public class Test {

    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Assistant", "ivivan@mailbox.com", "892312312", 30000, 30);
        persArray[1] = new Person("Vasilev Ivan", "Engineer", "vasivan@mailbox.com", "894313312", 40000, 41);
        persArray[2] = new Person("Ivanova Dariya", "Scientist", "ivdariya@mailbox.com", "892617322", 50000, 55);
        persArray[3] = new Person("Malysheva Ekaterina", "Engineer", "malkate@mailbox.com", "8912134412", 60000, 33);
        persArray[4] = new Person("Petrov Ilya", "Scientist", "petilya@mailbox.com", "892315552", 70000, 50);
        for (int i = 0; i < 5; i++) {
            if (persArray[i].getAge() >= 40) {
                persArray[i].info();
            }
        }
    }
}
