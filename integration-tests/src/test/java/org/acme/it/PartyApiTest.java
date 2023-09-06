package org.acme.it;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import io.bitbuild.test.BitbuildTestSupport;

public class PartyApiTest extends BitbuildTestSupport
{
  @Test
  public void testCustomerEndpoint() throws Exception
  {
    String requestBody = this.getResourceContent("json/party.json");

    given()
      .log().all()
      .header("Content-type", "application/json")
      .header("Accept", "application/json")
      .and()
        .body(requestBody)
      .when()
        .post("/customer")
      .then()
        .log().all()
        .statusCode(200)
        .body(is("{\"code\":\"SUCCESS\",\"description\":\"Successfully processed CUSTOMER party Piet\"}"));
  }

  @Test
  public void testPersonEndpoint()
  {
    String requestBody = "{\"id\":\"1\",\"firstName\":\"Piet\",\"lastName\":\"Pompies\"}";

    given()
     .log().all()
     .header("Content-type", "application/json")
     .header("Accept", "application/json")
     .and()
     .body(requestBody)
     .when()
       .post("/person")
     .then()
      .log().all()
       .statusCode(200)
       .body(is("{\"code\":\"SUCCESS\",\"description\":\"Successfully processed PERSON party Piet\"}"));
  }
}
