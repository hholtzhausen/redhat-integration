package org.acme.person;

import javax.inject.Inject;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.HttpHeaders;

import org.apache.camel.CamelContext;

import io.smallrye.common.annotation.Blocking;

import org.acme.*;
import org.examples.party.*;

import io.bitbuild.lib.camel.support.jaxrs.JaxrsSupport;

public class PersonResourceImpl extends JaxrsSupport implements PersonResource
{
  @Inject
  CamelContext context;
 
  @Inject
  HttpHeaders httpHeaders;

  @Override
  @Blocking
  public Status createPerson(Party person)
  {
    Response response = callCamelRoute("seda:personAPI?waitForTaskToComplete=Always",
                                       person,
                                       Party.class,
                                       Status.class,
                                       Status.class,200,400,
                                       httpHeaders,
                                       null,context);

    return (Status)response.getEntity();
  }


  @Override
  @Blocking
  public Party getPerson(String id)
  {
    Response response = callCamelRoute("seda:personGetAPI?waitForTaskToComplete=Always",
                                       "<xml><id>"+id+"</id></xml>",
                                       String.class,
                                       Party.class,
                                       Status.class,200,400,
                                       httpHeaders,
                                       null,context);
    return (Party)response.getEntity();

  }
}
