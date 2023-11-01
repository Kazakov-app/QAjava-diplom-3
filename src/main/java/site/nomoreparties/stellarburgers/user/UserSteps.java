package site.nomoreparties.stellarburgers.user;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import site.nomoreparties.stellarburgers.config.RequestSpec;
import site.nomoreparties.stellarburgers.constantsApi.ApiEndPoints;

import static site.nomoreparties.stellarburgers.constantsApi.ApiEndPoints.*;

public class UserSteps extends RequestSpec {

    @Step("Register new user /api/auth/register")
    public ValidatableResponse userCreate(UserConstructor userConstructor) {
        return requestSpec()
                .body(userConstructor)
                .when()
                .post(ApiEndPoints.USER_CREATE_POST)
                .then();
    }

    @Step("Get user date /api/auth/user")
    public ValidatableResponse userReceiving(UserConstructor userConstructor, String accessToken) {
        return requestSpec()
                .header("Authorization", accessToken)
                .body(userConstructor)
                .when()
                .get(USER_RECEIVING_DATA_GET)
                .then();
    }

    @Step("Logout systems /api/auth/logout")
    public ValidatableResponse userLogOut(String refreshToken) {
        return requestSpec()
                .body(refreshToken)
                .when()
                .post(USER_LOGOUT_POST)
                .then();
    }

    @Step("Delete user /api/auth/user")
    public ValidatableResponse userDelete(String accessToken) {
        return requestSpec()
                .auth().oauth2(accessToken)
                .when()
                .delete(USER_DELETE)
                .then();
    }
}


