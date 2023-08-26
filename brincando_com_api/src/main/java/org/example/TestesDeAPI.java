package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class TestesDeAPI {

    @Test
    public void loginComSUCESSO() {
        Response response = RestAssured.given()
            .contentType(ContentType.JSON)
            .body("{\n" +
                    "   \"email\": \"eve.holt@reqres.in\",\n" +
                    "   \"password\": \"cityslicka\"\n" +
                    "}")
            .post("https://reqres.in/api/login");

        int statusEsperado = 200;
        int statusResponse = response.statusCode();
        Assert.assertEquals(statusEsperado, statusResponse);
        System.out.println(statusResponse);

        String boryEsperado = "{\"token\":\"QpwL5tke4Pnpja7X4\"}";
        String boryResponse = response.body().asString();
        Assert.assertEquals(boryEsperado, boryResponse);
        System.out.println(boryResponse);
    }

    @Test
    public void loginComUsuarioNaoCadastrado() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "   \"email\": \"mickhill@hotmail.com\",\n" +
                        "   \"password\": \"cityslicka\"\n" +
                        "}")
                .post("https://reqres.in/api/login");

        int statusEsperado = 400;
        int statusResponse = response.statusCode();
        Assert.assertEquals(statusEsperado, statusResponse);
        System.out.println(statusResponse);

        String boryEsperado = "{\"error\":\"user not found\"}";
        String boryResponse = response.body().asString();
        Assert.assertEquals(boryEsperado, boryResponse);
        System.out.println(boryResponse);
    }

    @Test
    public void loginComSenhamInvalida() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "   \"email\": \"eve.holt@reqres.in\",\n" +
                        "   \"password\": \"####\"\n" +
                        "}")
                .post("https://reqres.in/api/login");

        int statusEsperado = 400;
        int statusResponse = response.statusCode();
        Assert.assertEquals(statusEsperado, statusResponse);
        System.out.println(statusResponse);

        String boryEsperado = "{\"error\":\"senha invalida\"}";
        String boryResponse = response.body().asString();
        Assert.assertEquals(boryEsperado, boryResponse);
        System.out.println(boryResponse);
    }
}