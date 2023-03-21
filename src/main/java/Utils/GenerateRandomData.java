package Utils;

import com.github.javafaker.Faker;

public class GenerateRandomData {
    Faker faker = new Faker();
    String name = faker.name().fullName();
    String email = faker.bothify("??????###@yandex.ru");
    String password = faker.bothify("##########");

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
