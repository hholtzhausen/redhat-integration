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

@Path("/person")
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
@Tag( ref = "Party Resources" )
public interface PersonResource
{
  @POST
  public Status createPerson(Party party);

  @GET
  @Path("/{id}")
  public Party getPerson(@PathParam("id") String id);
}
