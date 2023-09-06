package org.acme.personws;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;

import javax.inject.Inject;
import javax.enterprise.context.ApplicationScoped;

import io.smallrye.common.annotation.Blocking;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.BindingType;

import org.tempuri.*;

@WebService(endpointInterface = "org.tempuri.PersonWS", 
            targetNamespace = "http://tempuri.org/",
            portName="PersonWSSoap",
            serviceName="PersonService")
//@BindingType(javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
@ApplicationScoped
public class PersonWSImpl implements PersonWS
{
  @Inject
  CamelContext context;

  @Override
  @Blocking
  public PersonStatus process(Person person)
  {
    ProducerTemplate producer = context.createProducerTemplate();
    PersonStatus s = producer.requestBodyAndHeaders("bitbuilddirect:createCustomer",
                                                     person, 
                                                     null,
                                                     PersonStatus.class);
    return s;
  }
}
