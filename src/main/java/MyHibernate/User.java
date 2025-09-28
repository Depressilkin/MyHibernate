package MyHibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email; 
    private int age;
    private String created_at;

    public User(){}

    public User(String name, String email, int age, String created_at){
        this.name = name;
        this.email =  email; 
        this.age = age;
        this.created_at = created_at;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getCreated_at() {
        return created_at;
    }

    // Сеттеры
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Возраст не может быть отрицательным");
        }
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}

