package site.nomoreparties.stellarburgers.user.client;
import io.restassured.response.Response;
import site.nomoreparties.stellarburgers.user.client.RestClient;
import site.nomoreparties.stellarburgers.user.dto.UserCreateRequest;
import site.nomoreparties.stellarburgers.user.dto.UserLoginRequest;

public class UserClient extends RestClient {

    public Response create (UserCreateRequest userCreateRequest){
        return getDefaultRequestSpecification()
                .body(userCreateRequest)
                .when()
                .post("/api/auth/register");
    }

    public Response login (UserCreateRequest userCreateRequest){
        return getDefaultRequestSpecification()
                .body(userCreateRequest)
                .when()
                .post("/api/auth/login");
    }

    public Response delete (String accessToken){
        return getDefaultRequestSpecification()
                .header("Authorization", accessToken)
                .delete("/api/auth/user");
    }
}
