package site.nomoreparties.stellarburgers.user.client;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static site.nomoreparties.stellarburgers.user.config.Config.BASE_URL;

public abstract class RestClient {
    protected RequestSpecification getDefaultRequestSpecification(){
        return  given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON);

    }
}
