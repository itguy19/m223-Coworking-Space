package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.Optional;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.ApplicationUser;
import ch.zli.m223.model.Booking;
import ch.zli.m223.service.BookingService;
import ch.zli.m223.service.UserService;

@Path("/bookings")
@Tag(name = "Bookings", description = "Handling of bookings")
@RolesAllowed({"member", "admin"})
public class BookingController {

    @Inject
    BookingService bookingService;

    @Inject
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all Bookings", description = "Returns a list of all bookings.")
    public List<Booking> indexAll() {
        return bookingService.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index a booking", description = "Returns a booking.")
    public Booking index(@PathParam("id") Long id) {
        return bookingService.findBooking(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new booking.", description = "Creates a new booking and returns the newly added booking.")
    public Response create(Booking booking, @Context SecurityContext sc) {
      Optional<ApplicationUser> user = userService.findByEmail(sc.getUserPrincipal().getName());
      booking.setUser(user.orElse(null));
      try {
         bookingService.createBooking(booking);
      } catch (Exception exception) {
         return Response.status(400, "Erstellung der Buchung fehlgeschlagen").build();
      }
      return Response.status(201, "Buchung erstellt").build();
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Deletes a booking.", description = "Deletes a booking and returns the deleted booking.")
    public Response delete(@PathParam("id") Long id) {
      try {
         bookingService.deleteBooking(id);
      } catch (Exception exception) {
         return Response.status(400, "Benutzer wurde nicht angelegt").build();
      }
      return Response.status(201, "Benutzer erfolgreich angelegt").build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Updates a booking.", description = "Updates a booking and returns the updated booking.")
    public Booking update(@PathParam("id") Long id, Booking booking, @Context SecurityContext sc) {
      Optional<ApplicationUser> user = userService.findByEmail(sc.getUserPrincipal().getName());
      booking.setUser(user.orElse(null));
      return bookingService.updateBooking(id, booking);
    }

    @PUT
    @Path("/approve/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    @Operation(summary = "Approve a booking.", description = "Approves a booking and returns the approoved booking.")
    public Response approveBooking(@PathParam("id") Long id) {
      try {
         bookingService.approveBooking(id);
      } catch (Exception exception) {
         return Response.status(200, "Buchung genehmigt").build();
      }
      return Response.status(404, "Buchung konnte nicht genehmigt werden").build();
    }

    @PUT
    @Path("/reject/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    @Operation(summary = "Reject a booking.", description = "Reject a booking and returns the rejected booking.")
    public Response rejectBooking(@PathParam("id") Long id) {
      try {
         bookingService.rejectBooking(id);
       } catch (Exception exception) {
         return Response.status(200, "Buchung abgelehnt").build();
      }
      return Response.status(404, "Buchung konnte nicht abgelehnt werden").build();
    }
}