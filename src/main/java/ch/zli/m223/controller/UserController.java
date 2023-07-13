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
   public void delete(@PathParam("id") Long id) {
         userService.deleteUser(id);
   }

   @Path("/{id}")
   @PUT
   @Operation(
         summary = "Updates an user.",
         description = "Updates an user by its id."
   )
   public ApplicationUser update(@PathParam("id") Long id, ApplicationUser user) {
         return userService.updateUser(id, user);
   }
}
