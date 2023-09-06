package org.acme.personws;

import java.net.URI;
import java.net.MalformedURLException;

import javax.inject.Named;
import javax.inject.Inject;
import javax.enterprise.inject.Produces;
import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.RestClientBuilder;
//import io.quarkus.oidc.token.propagation.AccessTokenRequestFilter;

import org.acme.CustomerResource;

@ApplicationScoped
public class RestClientProducer
{
  @ConfigProperty(name = "app.customer.baseuri")
  String customerBaseUri;

  @Produces
  @Named
  public CustomerResource customerResource() throws MalformedURLException
  {
    CustomerResource customerResource = RestClientBuilder.newBuilder()
                                            .baseUri(URI.create(customerBaseUri))
//                                            .register(AccessTokenRequestFilter.class)
                                            .build(CustomerResource.class);

    return customerResource;
  }
}
