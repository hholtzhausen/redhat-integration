package org.foo;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PersonResourceTest 
{
//  @Test
  public void testPersonEndpoint() 
  {
    String requestBody = "{\"id\":\"1\",\"firstName\":\"Piet\",\"lastName\":\"Pompies\"}";

    given()
      .header("Content-type", "application/json")
      .header("Accept", "application/json")
      .and()
      .body(requestBody)
      .when()
        .post("/person")
      .then()
        .statusCode(200)
        .body(is("{\"code\":\"SUCCESS\",\"description\":\"Successfully processed2 Piet\"}"));
  }
}
