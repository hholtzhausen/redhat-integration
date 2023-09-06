package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirements;

import org.examples.party.*;

@Path("/customer")
@Consumes({"application/json"})
@Produces({"application/json"})
@SecurityRequirements(
  value = { @SecurityRequirement (
              name  = "basicAuth"
            ),
            @SecurityRequirement (
              name  = "OIDC"
            )
          }
)
@Tag(name = "Party Resources",
     description = "Party API Operations" )
public interface CustomerResource
{
  @POST
  public Status createCustomer(Party party);
                               

  @GET
  @Path("/{id}")
  public Party getCustomer(@PathParam("id") String id);
}
