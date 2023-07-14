package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.ApplicationUser;
import ch.zli.m223.service.UserService;

@Path("/users")
@Tag(name = "Users", description = "Handling of users")
public class UserController {

   @Inject
   UserService userService;

   @GET
   @Produces(MediaType.APPLICATION_JSON)
   @Operation(
         summary = "Index all users.", 
         description = "Returns a list of all users."
   )
   public List<ApplicationUser> index() {
         return userService.findAll();
   }

   @Path("/{id}")
   @DELETE
   @Operation(
         summary = "Deletes an user.",
         description = "Deletes an user by its id."
   )
   public Response delete(@PathParam("id") Long id) {
      try {
            userService.deleteUser(id);
      } catch (Exception exception) {
            return Response.status(404, "Benutzer konnte nicht gelöscht").build();
      }
      return Response.status(204, "Benutzer erfolgreich gelöscht").build();
   }

   @Path("/{id}")
   @PUT
   @Consumes(MediaType.APPLICATION_JSON)
   @Operation(
         summary = "Updates an user.",
         description = "Updates an user by its id."
   )
   public Response update(@PathParam("id") Long id, ApplicationUser user) {
      try {
            userService.updateUser(id, user);
      } catch (Exception exception) {
            return Response.status(404, "Der Benutzer konnte nicht überschrieben werden").build();
      }
      return Response.status(200, "Der Benutzer wurde erfolgreich überschrieben").build();
   }
}
