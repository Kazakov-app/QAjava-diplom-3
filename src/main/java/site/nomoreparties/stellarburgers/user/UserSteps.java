package site.nomoreparties.stellarburgers.user;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import site.nomoreparties.stellarburgers.config.RequestSpec;
import site.nomoreparties.stellarburgers.constantsApi.ApiEndPoints;

public class UserSteps extends RequestSpec {

    @Step("Register new user /api/auth/register")
    public ValidatableResponse userCreate(UserConstructor userConstructor) {
        return requestSpec()
                .body(userConstructor)
                .when()
                .post(ApiEndPoints.USER_CREATE_POST)
                .then();
    }
}