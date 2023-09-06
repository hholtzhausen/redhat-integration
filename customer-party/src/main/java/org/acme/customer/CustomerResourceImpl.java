package org.acme.customer;

import org.apache.camel.CamelContext;

//import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.HttpHeaders;

import io.smallrye.common.annotation.Blocking;

import javax.inject.Inject;

import org.acme.*;
import org.examples.party.*;

import io.bitbuild.lib.camel.support.jaxrs.JaxrsSupport;


public class CustomerResourceImpl extends JaxrsSupport implements CustomerResource 
{
  @Inject
  CamelContext context;

  @Inject
  HttpHeaders httpHeaders;

//  @Inject
//  JsonWebToken jwt;


  @Override
  @Blocking
  public Status createCustomer(Party customer)
  {
/*
    if(jwt.getRawToken() != null)
    {
      for(String claimName: jwt.getClaimNames())
      {
        Object claimVal = jwt.getClaim(claimName);
        System.out.println(claimName + ": "+claimVal.getClass().getName()+": "+claimVal.toString());
      }
    }
*/

    Response response = callCamelRoute("seda:customerAPI?waitForTaskToComplete=Always",
                                       customer,
                                       Party.class,
                                       Status.class,
                                       Status.class,200,400,
                                       httpHeaders,
                                       null,context);
    return (Status)response.getEntity();
  }


  @Override
  @Blocking
  public Party getCustomer(String id)
  {
/*
    System.out.println("CLAIM NAMES: "+jwt.getClaimNames());

    for(String claimName: jwt.getClaimNames())
    {
      Object claimVal = jwt.getClaim(claimName);
      System.out.println(claimName + ": "+claimVal.getClass().getName()+": "+claimVal.toString());
    }
*/
    Response response = callCamelRoute("seda:customerGetAPI?waitForTaskToComplete=Always",
                                       "<xml><id>"+id+"</id></xml>",
                                       String.class,
                                       Party.class,
                                       Status.class,200,400,
                                       httpHeaders,
                                       null,context);
    return (Party)response.getEntity();
  }
}
