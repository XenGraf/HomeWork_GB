public class Person {

    private String name;
    private String position;
    private String email;
    private String tel;
    private int salary;
    private int age;

    public Person() {
        name = "Ivanov Ivan";
        position = "Engineer" ;
        email = "ivivan@mailbox.com";
        tel = "892312312";
        salary = 30000;
        age = 30;
    }

    public Person(String name, String position, String email, String tel, int salary, int age) {
        this.name = name;
        this.position = position ;
        this.email = email;
        this.tel = tel;
        this.salary = salary;
        this.age = age;
    }

    public void info() {
        System.out.println("ФИО пользователя: " + name+ "; Должность: " + position + "; email: " + email + "; Телефон: " + tel + "; Зарплата: " + salary + "; Возраст: " + age);
    }


    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Assistant", "ivivan@mailbox.com", "892312312", 30000, 30);
        persArray[1] = new Person("Vasilev Ivan", "Engineer", "vasivan@mailbox.com", "894313312", 40000, 41);
        persArray[2] = new Person("Ivanova Dariya", "Scientist", "ivdariya@mailbox.com", "892617322", 50000, 55);
        persArray[3] = new Person("Malysheva Ekaterina", "Engineer", "malkate@mailbox.com", "8912134412", 60000, 33);
        persArray[4] = new Person("Petrov Ilya", "Scientist", "petilya@mailbox.com", "892315552", 70000, 50);
        for (int i = 0; i < 5; i++) {
            if (persArray[i].age >= 40) {
                persArray[i].info();
            }
        }
    }
}


