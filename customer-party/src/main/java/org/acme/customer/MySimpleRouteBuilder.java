package org.acme.customer;

import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import io.bitbuild.lib.camel.AbstractBaseRouteBuilder;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class MySimpleRouteBuilder extends AbstractBaseRouteBuilder
{
  @ConfigProperty(name = "app.test.prop1")
  String prop1;
  @ConfigProperty(name = "app.secret.prop1")
  String sec1;
  @ConfigProperty(name = "app.secret.prop2")
  String sec2;

  @Override
  protected String getBaseRouteId()
  {
    return MySimpleRouteBuilder.class.getSimpleName();
  }

   @Override
  protected int getMaximumRedeliveries()
  {
    return 0;
  }

  @Override
  protected boolean getUseOriginalMessage()
  {
    return false;
  }


  @Override
  protected boolean useDynamicAuditLogCategory()
  {
    return true;
  }


  @Override
  public void configure() throws Exception
  {
    super.configure();

    from("direct:simple")
      .routeId(getRouteId("simple"))
      .log("BODY: ${body}")
    .end();

    from("direct:myEnricher")
      .routeId(getRouteId("myEnricher"))
      .setHeader("prop1",constant(prop1))
      .setHeader("sec1",constant(sec1))
      .setHeader("sec2",constant(sec2))
      .log("HEADERS: ${headers}")
    .end();
  }
}
