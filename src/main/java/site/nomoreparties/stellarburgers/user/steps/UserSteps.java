package site.nomoreparties.stellarburgers.user.steps;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import site.nomoreparties.stellarburgers.user.dto.UserCreateRequest;
import site.nomoreparties.stellarburgers.user.client.UserClient;

public class UserSteps {
    private final UserClient userClient;
    public UserSteps(UserClient userClient){
        this.userClient=userClient;
    }
    @Step("Send POST request to api/v1/courier")
    public ValidatableResponse create(String login, String password, String firstName) {
        UserCreateRequest userCreateRequest = new UserCreateRequest();
        userCreateRequest.setEmail(login);
        userCreateRequest.setPassword(password);
        userCreateRequest.setName(firstName);
        return userClient.create(userCreateRequest).then();
    }
    public String token(String email, String password, String name) {
        UserCreateRequest userCreateRequest = new UserCreateRequest();
        userCreateRequest.setEmail(email);
        userCreateRequest.setPassword(password);
        userCreateRequest.setName(name);
        return userClient.login(userCreateRequest).then().extract().body().path("accessToken");
    }
        public void delete (String accessToken) {
            userClient.delete(accessToken).then();
    }
}
