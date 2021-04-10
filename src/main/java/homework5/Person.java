package homework5;

public class Person {

    private final String name;
    private final String position;
    private final String email;
    private final String tel;
    private final int salary;
    private final int age;

    public Person() {
        name = "Ivanov Ivan";
        position = "Engineer";
        email = "ivivan@mailbox.com";
        tel = "892312312";
        salary = 30000;
        age = 30;
    }

    public Person(String name, String position, String email, String tel, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.tel = tel;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void info() {
        System.out.println("ФИО пользователя: " + name + "; Должность: " + position + "; email: " + email + "; Телефон: " + tel + "; Зарплата: " + salary + "; Возраст: " + age);
    }

}
