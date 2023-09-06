package org.acme.it;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import io.bitbuild.test.BitbuildTestSupport;

public class PersonWsTest extends BitbuildTestSupport
{
  @Test
  public void testWsEndpoint() throws Exception
  {
    String requestBody = this.getResourceContent("xml/party.xml");

    given()
      .log().all()
      .baseUri("https://person-ws-middleware.apps-crc.testing")
      .basePath("/cxf")
      .header("Content-type", "application/xml")
      .header("Accept", "application/xml")
      .and()
        .body(requestBody)
      .when()
        .post("/person")
      .then()
        .log().all()
        .statusCode(200);
  }
}
