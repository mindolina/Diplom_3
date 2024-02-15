package site.nomoreparties.stellarburgers.user.create;

import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import site.nomoreparties.stellarburgers.user.client.UserClient;
import site.nomoreparties.stellarburgers.user.steps.UserSteps;

public class CreateUser {
    private UserSteps userSteps;
    String[] domenName=new String[]{"@mail.ru","@yandex.ru","@gmail.com"};
    String email = RandomStringUtils.random(10, "qwertyyuiopasdfghjklzxcvbnm") + domenName[RandomUtils.nextInt(0,domenName.length)];
    String password = RandomStringUtils.random(8, "qwertyyuiopasdfghjklzxcvbnm1234567890");
    String name = RandomStringUtils.random(10, "qwertyyuiopasdfghjklzxcvbnm");
    String accessToken ="";
    @Step("Создать тестового юзера")
    public void createUser(){
        userSteps=new UserSteps(new UserClient());
        userSteps.create(email,password,name);
    }
    @Step("Удалить тестового юзера")
    public void deleteUser(){
        userSteps=new UserSteps(new UserClient());
        this.accessToken=userSteps.token(email, password, name);
        userSteps.delete(accessToken);
    }

    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
