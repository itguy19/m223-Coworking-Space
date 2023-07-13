package ch.zli.m223.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.service.AuthService;
import ch.zli.m223.model.Credential;
import jakarta.validation.Valid;

@Path("/")
@Tag(name = "Authentication", description = "Handling authentication")
public class AuthController {
   @Inject
   AuthService authService;

   @POST
   @Path("/login")
   @Consumes(MediaType.APPLICATION_JSON)
   @Operation(summary = "Authenticate a user.", description = "Returns a token upon successful authentication.")
   public Response login(@Valid Credential credential) {
      return this.authService.authenticate(credential);
   }

   @POST
   @Path("/register")
   @Consumes(MediaType.APPLICATION_JSON)
   @Operation(summary = "Authenticate a user.", description = "Returns a token upon successful authentication.")
   public Response register(@Valid Credential credential) {
      return this.authService.authenticate(credential);
   }
}