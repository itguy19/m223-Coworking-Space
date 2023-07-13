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
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Booking;
import ch.zli.m223.service.BookingService;

@Path("/bookings")
@Tag(name = "Bookings", description = "Handling of bookings")
@RolesAllowed({"member", "admin"})
public class BookingController {

    @Inject
    BookingService bookingService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
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
    public Booking create(Booking booking) {
       return bookingService.createBooking(booking);
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Deletes a booking.", description = "Deletes a booking and returns the deleted booking.")
    public void delete(@PathParam("id") Long id) {
       bookingService.deleteBooking(id);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Updates a booking.", description = "Updates a booking and returns the updated booking.")
    public Booking update(@PathParam("id") Long id, Booking entry) {
       return bookingService.updateBooking(id, entry);
    }

    @PUT
    @Path("/{id}/approove")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    @Operation(summary = "Approove a booking.", description = "Approoves a booking and returns the approoved booking.")
    public void approoveBooking(@PathParam("id") Long id) {
       bookingService.approoveBooking(id);
    }

    @PUT
    @Path("/{id}/reject")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    @Operation(summary = "Reject a booking.", description = "Reject a booking and returns the rejected booking.")
    public void rejectBooking(@PathParam("id") Long id) {
       bookingService.rejectBooking(id);
    }
}