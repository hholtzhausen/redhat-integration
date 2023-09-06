package org.acme.personws;

import javax.inject.Named;
import javax.enterprise.inject.Produces;

import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.direct.DirectComponent;

import io.bitbuild.lib.camel.AbstractBaseRouteBuilder;

@ApplicationScoped
public class MySimpleRouteBuilder extends AbstractBaseRouteBuilder
{
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
      .log("enricher")
    .end();

    from("direct:errorHandler")
      .routeId(getRouteId("errorHandler"))
      .log("ERROR: ${exchangeProperty.CamelExceptionCaught.printStackTrace()}")
    .end();
  }


  @Produces
  @ApplicationScoped
  @Named("bitbuilddirect")
  DirectComponent bitbuildDirectComponent()
  {
    DirectComponent component = new DirectComponent();
    return component;
  }
}
