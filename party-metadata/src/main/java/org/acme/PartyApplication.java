package org.acme;

import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;

import org.eclipse.microprofile.openapi.annotations.security.OAuthFlow;
import org.eclipse.microprofile.openapi.annotations.security.OAuthFlows;
import org.eclipse.microprofile.openapi.annotations.security.OAuthScope;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;
import org.eclipse.microprofile.openapi.annotations.security.SecuritySchemes;

@SecuritySchemes (
  value = { 
            @SecurityScheme ( 
              securitySchemeName = "OIDC",
              type = SecuritySchemeType.OAUTH2,
              flows = @OAuthFlows (
                        clientCredentials = 
                        @OAuthFlow(tokenUrl = "",
                                   scopes = { @OAuthScope ( name = "roles", description = "realm/client roles")}
                        )
              )
            )
          }
)
public class PartyApplication extends Application
{
}
